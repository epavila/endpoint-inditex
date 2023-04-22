package com.eavila.endpoint.model.request;

import com.eavila.endpoint.model.entity.Price;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceRequest implements Serializable {

    private LocalDateTime date;
    private Long idBrand;
    private Long idRate;
    private Long idProduct;
    private Price price;

}


