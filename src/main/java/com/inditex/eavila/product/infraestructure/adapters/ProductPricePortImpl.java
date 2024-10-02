package com.inditex.eavila.product.infraestructure.adapters;

import java.time.LocalDateTime;

import com.inditex.eavila.product.application.ports.ProductPricePort;
import com.inditex.eavila.product.domain.entities.ProductPrice;
import com.inditex.eavila.product.infraestructure.entities.PriceEntity;
import com.inditex.eavila.product.domain.exceptions.IdNotFoundException;
import com.inditex.eavila.product.infraestructure.repositories.PriceRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class ProductPricePortImpl implements ProductPricePort {

  private PriceRepository priceRepository;


  public ProductPrice findCurrentProductPrice(LocalDateTime applicationDate, Long idProduct, Long idBrand) {

    PriceEntity priceEntity = this.priceRepository.findCurrentProductPrice(applicationDate, idProduct, idBrand, PageRequest.of(0, 1))
      .getContent().get(0);

    return ProductPrice.builder()
      .prdId(priceEntity.getProduct().getPrdId())
      .brdId(priceEntity.getBrand().getBrdId())
      .rtsApply(priceEntity.getRate().getRtsApply())
      .startDate(priceEntity.getStartDate())
      .endDate(priceEntity.getEndDate())
      .price(priceEntity.getPrcPrice())
      .build();

  }

}
