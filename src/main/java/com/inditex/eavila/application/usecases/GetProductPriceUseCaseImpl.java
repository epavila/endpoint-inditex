package com.inditex.eavila.application.usecases;

import com.inditex.eavila.application.ports.ProductPricePort;
import com.inditex.eavila.application.response.ProductoPriceResponse;
import com.inditex.eavila.domain.entities.ProductPrice;
import com.inditex.eavila.domain.ports.GetProductPriceUseCase;
import com.inditex.eavila.infraestructure.request.ProductPriceRequest;

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
    ProductPrice productPrice = this.productPricePort.findCurrentProductPrice(request.getApplicationDate(), request.getIdProduct(), request.getIdBrand());

    ProductoPriceResponse productPriceResponse = new ProductoPriceResponse();
    BeanUtils.copyProperties(productPrice, productPriceResponse);

    return productPriceResponse;
  }
}
