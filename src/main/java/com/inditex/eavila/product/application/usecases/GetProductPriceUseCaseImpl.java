package com.inditex.eavila.product.application.usecases;

import com.inditex.eavila.product.application.ports.ProductPricePort;
import com.inditex.eavila.product.application.response.ProductoPriceResponse;
import com.inditex.eavila.product.domain.entities.ProductPrice;
import com.inditex.eavila.product.domain.exceptions.PriceNotFoundException;
import com.inditex.eavila.product.domain.ports.GetProductPriceUseCase;
import com.inditex.eavila.product.infraestructure.request.ProductPriceRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class GetProductPriceUseCaseImpl implements GetProductPriceUseCase {

  private final ProductPricePort productPricePort;

  @Override
  public ProductoPriceResponse execute(ProductPriceRequest request) {
    try {
      ProductPrice productPrice = this.productPricePort.findCurrentProductPrice(request.getApplicationDate(), request.getIdProduct(), request.getIdBrand());

      ProductoPriceResponse productPriceResponse = new ProductoPriceResponse();
      BeanUtils.copyProperties(productPrice, productPriceResponse);

      return productPriceResponse;

    } catch (IndexOutOfBoundsException ex) {
      log.error("Error obtaining price, >>> Message: {}", ex.getMessage());
      throw new PriceNotFoundException("price");
    }
  }
}
