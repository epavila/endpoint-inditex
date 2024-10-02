package com.inditex.eavila.product.infraestructure.openapi;

public class PriceDocs {

    public static class FindCurrentPrice{
        public static final String VALUE = "Return current product price";
        public static final String NOTES = "## Find current price \n" +
                "### Returned one object with an active current price \n" +
                "\n" +
                "   * ResponseEntity<PriceResponse> findCurrentProductPrice()";
    }

}
