package com.eavila.endpoint.controllers;

import com.eavila.endpoint.infraestructure.services.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @author eavila
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PriceControllerTest {

    @Autowired
    private WebTestClient client;

    @Autowired
    private PriceService priceService;

    /**
     * @result
     * Test 1
     * Validation search when date equals: 2020-06-14 10:00
     */
    @Test
    void testFindCurrentPriceWhenDateEquals_20200614_10_00() {
        String applicationDate = "2020-06-14 10:00";
        Long idProduct = 35455L;
        Long idBrand = 1L;

        client.get().uri("v1/price/find-price-product/"+ applicationDate +"/"+ idProduct +"/" + idBrand ).exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.price").value( val -> assertEquals(35.50, val));
    }


    /**
     * @result
     * Test 2
     * Validation search when date equals: 2020-06-14 16:00
     */
    @Test
    void testFindCurrentPriceWhenDateEquals_20200614_16_00() {
        String applicationDate = "2020-06-14 16:00";
        Long idProduct = 35455L;
        Long idBrand = 1L;

        client.get().uri("v1/price/find-price-product/"+ applicationDate +"/"+ idProduct +"/" + idBrand ).exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.price").value( val -> assertEquals(25.45, val));

    }


    /**
     * @result
     * Test 3
     * Validation search when date equals: 2020-06-14 21:00
     */
    @Test
    void testFindCurrentPriceWhenDateEquals_20200614_21_00() {
        String applicationDate = "2020-06-14 21:00";
        Long idProduct = 35455L;
        Long idBrand = 1L;

        client.get().uri("v1/price/find-price-product/"+ applicationDate +"/"+ idProduct +"/" + idBrand ).exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.price").value( val -> assertEquals(35.50, val));

    }



    /**
     * @result
     * Test 4
     * Validation search when date equals: 2020-06-15 10:00
     */
    @Test
    void testFindCurrentPriceWhenDateEquals_20200615_10_00() {
        String applicationDate = "2020-06-15 10:00";
        Long idProduct = 35455L;
        Long idBrand = 1L;

        client.get().uri("v1/price/find-price-product/"+ applicationDate +"/"+ idProduct +"/" + idBrand ).exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.price").value( val -> assertEquals(30.50, val));

    }


    /**
     * @result
     * Test 5
     * Validation search when date equals: 2020-06-16 21:00
     */
    @Test
    void testFindCurrentPriceWhenDateEquals_20200616_21_00() {
        String applicationDate = "2020-06-16 21:00";
        Long idProduct = 35455L;
        Long idBrand = 1L;

        client.get().uri("v1/price/find-price-product/"+ applicationDate +"/"+ idProduct +"/" + idBrand ).exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.price").value( val -> assertEquals(38.95, val));
    }

}
