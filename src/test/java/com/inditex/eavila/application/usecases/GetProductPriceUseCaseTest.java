package com.inditex.eavila.application.usecases;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.inditex.eavila.application.ports.ProductPricePort;
import com.inditex.eavila.application.response.ProductoPriceResponse;
import com.inditex.eavila.domain.entities.ProductPrice;
import com.inditex.eavila.domain.ports.GetProductPriceUseCase;
import com.inditex.eavila.infraestructure.constants.GeneralConstants;
import com.inditex.eavila.infraestructure.request.ProductPriceRequest;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class GetProductPriceUseCaseTest {

  private ProductPricePort productPricePort = mock(ProductPricePort.class);

  private GetProductPriceUseCase getProductPriceUseCase = new GetProductPriceUseCaseImpl(productPricePort);


  @Test
  void execute_getFindCurrentProductPrice() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GeneralConstants.FORMAT_DATE);
    LocalDateTime startDate = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
    LocalDateTime endDate = LocalDateTime.parse("2020-12-31 23:59:59", formatter);
    Long idProduct = 35455L;
    Long idBrand = 1L;

    when(this.productPricePort.findCurrentProductPrice(startDate, idProduct, idBrand))
    .thenReturn(ProductPrice.builder()
      .prdId(idBrand)
      .brdId(idBrand)
      .rtsApply(new BigDecimal(5))
      .startDate(startDate)
      .endDate(endDate)
      .price(new BigDecimal(38.95))
      .build());

    ProductPriceRequest request = ProductPriceRequest.builder()
      .applicationDate(startDate)
      .idProduct(idProduct)
      .idBrand(idBrand)
      .build();
    ProductoPriceResponse productPriceResponse = getProductPriceUseCase.execute(request);

    assertNotNull(productPriceResponse);
    assertEquals(productPriceResponse.getPrice().setScale(2, RoundingMode.DOWN), new BigDecimal(38.95).setScale(2, RoundingMode.DOWN));

  }

}
