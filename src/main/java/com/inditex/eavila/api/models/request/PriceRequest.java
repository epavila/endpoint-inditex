package com.inditex.eavila.api.models.request;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.inditex.eavila.domain.entities.PriceEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceRequest implements Serializable {

    private LocalDateTime date;
    private Long idBrand;
    private Long idRate;
    private Long idProduct;
    private PriceEntity priceEntity;

}


