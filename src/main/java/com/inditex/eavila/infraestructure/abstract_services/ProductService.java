package com.inditex.eavila.infraestructure.abstract_services;


import com.inditex.eavila.api.models.response.PriceResponse;

public interface ProductService {

  PriceResponse findCurrentPrice(String applicationDate, Long idProduct, Long idBrand);

}
