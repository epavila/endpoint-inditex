package com.inditex.eavila.product.application.ports;

import java.time.LocalDateTime;

import com.inditex.eavila.product.domain.entities.ProductPrice;

public interface ProductPricePort {

  ProductPrice findCurrentProductPrice(LocalDateTime applicationDate, Long idProduct, Long idBrand);

}
