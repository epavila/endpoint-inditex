package com.inditex.eavila.domain.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class PriorityPriceEnumTest {

  @Test
  void testEnum() {
    assertEquals(PriorityPriceEnum.ZERO.name(), "ZERO");
    assertEquals(PriorityPriceEnum.ONE.name(), "ONE");
    assertEquals(PriorityPriceEnum.TWO.name(), "TWO");
    assertEquals(PriorityPriceEnum.THREE.name(), "THREE");
    assertEquals(PriorityPriceEnum.FOUR.name(), "FOUR");
  }

}
