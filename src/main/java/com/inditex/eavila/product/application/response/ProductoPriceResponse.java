package com.inditex.eavila.product.application.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductoPriceResponse {

    private Long prdId;
    private Long brdId;
    private BigDecimal rtsApply;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

}
