package com.inditex.eavila.domain.ports;

import com.inditex.eavila.application.response.ProductoPriceResponse;
import com.inditex.eavila.infraestructure.request.ProductPriceRequest;

public interface GetProductPriceUseCase {

  ProductoPriceResponse execute(ProductPriceRequest request);

}
