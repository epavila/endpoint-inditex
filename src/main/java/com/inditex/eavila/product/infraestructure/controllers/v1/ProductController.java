package com.inditex.eavila.product.infraestructure.controllers.v1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.inditex.eavila.product.application.response.ProductoPriceResponse;
import com.inditex.eavila.product.domain.ports.GetProductPriceUseCase;
import com.inditex.eavila.product.infraestructure.constants.GeneralConstants;
import com.inditex.eavila.product.infraestructure.exceptions.ErrorResponse;
import com.inditex.eavila.product.domain.exceptions.PriceNotFoundException;
import com.inditex.eavila.product.infraestructure.openapi.PriceDocs;
import com.inditex.eavila.product.infraestructure.request.ProductPriceRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.inditex.eavila.product.infraestructure.openapi.OpenApiDocs.ReturnCode.BAD_REQUEST;
import static com.inditex.eavila.product.infraestructure.openapi.OpenApiDocs.ReturnCode.BAD_REQUEST_CODE;
import static com.inditex.eavila.product.infraestructure.openapi.OpenApiDocs.ReturnCode.SUCCESS;
import static com.inditex.eavila.product.infraestructure.openapi.OpenApiDocs.ReturnCode.SUCCESS_CODE;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/v1/products")
@AllArgsConstructor
@Slf4j
@Validated
@Tag(name = "Endpoint to check product prices")
public class ProductController {

  private final GetProductPriceUseCase getProductPriceUseCase;
  private final ObjectMapper objectMapper;


  @Operation(summary = PriceDocs.FindCurrentPrice.VALUE, description = PriceDocs.FindCurrentPrice.NOTES)
  @ApiResponses(value = {
    @ApiResponse(responseCode = SUCCESS_CODE, description = SUCCESS, content = @Content(mediaType = "application/json",
      schema = @Schema(implementation = ProductoPriceResponse.class))),
    @ApiResponse(responseCode = BAD_REQUEST_CODE, description = BAD_REQUEST, content = @Content(schema = @Schema(implementation = Error.class))),
  })
  @GetMapping("/{idProduct}/brands/{idBrand}/prices/{applicationDate}")
  public ResponseEntity<?> findCurrentProductPrice(
    @Parameter(description = "Date places order, format: yyyy-mm-dd HH:mm or yyyy-mm-dd HH:mm:ss",
      required = true, example = "2020-06-14 10:00")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}(:\\d{2})?$", message = "Invalid date format, expected yyyy-MM-dd HH:mm or yyyy-MM-dd HH:mm:ss")
    @PathVariable @NotNull String applicationDate,

    @Parameter(description = "Id product", required = true, example = "35455")
    @NotNull(message = "Product ID cannot be null")
    @Min(value = 1, message = "Product ID must be a positive number")
    @PathVariable @NotNull @Positive Long idProduct,

    @Parameter(description = "Id brand", required = true, example = "1")
    @NotNull(message = "Brand ID cannot be null")
    @Min(value = 1, message = "Brand ID must be a positive number")
    @PathVariable @NotNull Long idBrand) {
    try {

      if (applicationDate.length() == 16) {
        applicationDate = applicationDate.concat(":00");
      }

      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GeneralConstants.FORMAT_DATE);
      LocalDateTime date = LocalDateTime.parse(applicationDate, formatter);

      ProductPriceRequest productPriceRequest = ProductPriceRequest.builder()
        .applicationDate(date)
        .idProduct(idProduct)
        .idBrand(idBrand)
        .build();
      ProductoPriceResponse priceResponse = this.getProductPriceUseCase.execute(productPriceRequest);
      return ResponseEntity.ok(priceResponse);

    } catch (PriceNotFoundException ex) {
      log.error("Price not found: {}", ex.getMessage());
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse("Price not found", List.of(ex.getMessage())));

    } catch (Exception ex) {
      log.error("Unexpected error: {}", ex.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorResponse("Unexpected error occurred", List.of(ex.getMessage())));
    }

  }

}
