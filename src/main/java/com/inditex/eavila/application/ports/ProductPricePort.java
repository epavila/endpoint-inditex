package com.inditex.eavila.application.ports;

import java.time.LocalDateTime;

import com.inditex.eavila.domain.entities.ProductPrice;

public interface ProductPricePort {

  ProductPrice findCurrentProductPrice(LocalDateTime applicationDate, Long idProduct, Long idBrand);

}
