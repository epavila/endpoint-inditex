package com.eavila.endpoint.controllers.v1;

import com.eavila.endpoint.infraestructure.services.PriceService;
import com.eavila.endpoint.model.response.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eavila.endpoint.utils.exception.Error;

import static com.eavila.endpoint.openapi.OpenApiDocs.ReturnCode.*;

@RestController
@RequestMapping("/v1/price")
@AllArgsConstructor
@Tag(name = "Endpoint to check product prices")
public class PriceController {

    private PriceService priceService;


    @Operation(summary = "Find current product price", description = "Returned one object with an active current price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = SUCCESS_CODE, description = SUCCESS, content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PriceResponse.class))),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Error.class))),
    })
    @GetMapping("/find-price-product/{applicationDate}/{idProduct}/{idBrand}")
    public ResponseEntity<PriceResponse> findCurrentPrice(@Parameter(description = "Date places order, format: yyyy-mm-dd HH:mm or yyyy-mm-dd HH:mm:ss",
            required = true,
            example = "2020-06-14 10:00") @PathVariable String applicationDate,
                                                          @Parameter(description = "Id product",
                                                                  required = true,
                                                                  example = "35455") @PathVariable Long idProduct,
                                                          @Parameter(description = "Id brand",
                                                                  required = true,
                                                                  example = "1") @PathVariable Long idBrand) {

        return ResponseEntity.ok(priceService.findCurrentPrice(applicationDate, idProduct, idBrand));

    }

}
