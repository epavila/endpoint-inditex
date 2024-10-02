package com.inditex.eavila.product.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.inditex.eavila.product.infraestructure.constants.GeneralConstants;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ProductPriceTest {

  @Test
  void testProductPrice() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(GeneralConstants.FORMAT_DATE);
    LocalDateTime startDate = LocalDateTime.parse("2020-06-14 10:00:00", formatter);
    LocalDateTime endDate = LocalDateTime.parse("2020-12-31 23:59:59", formatter);

    ProductPrice productPrice = ProductPrice.builder()
      .prdId(35455L)
      .brdId(1L)
      .rtsApply(new BigDecimal(5))
      .startDate(startDate)
      .endDate(endDate)
      .price(new BigDecimal(35.50))
      .build();

    assertEquals(35455L, productPrice.getPrdId());
    assertEquals(1L, productPrice.getBrdId());
    assertEquals(new BigDecimal(5), productPrice.getRtsApply());
    assertEquals(startDate, productPrice.getStartDate());
    assertEquals(endDate, productPrice.getEndDate());
    assertEquals(new BigDecimal(35.50), productPrice.getPrice());
  }

}
