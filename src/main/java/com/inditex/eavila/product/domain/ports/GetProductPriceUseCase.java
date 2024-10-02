package com.inditex.eavila.product.domain.ports;

import com.inditex.eavila.product.application.response.ProductoPriceResponse;
import com.inditex.eavila.product.infraestructure.request.ProductPriceRequest;

public interface GetProductPriceUseCase {

  ProductoPriceResponse execute(ProductPriceRequest request);

}
