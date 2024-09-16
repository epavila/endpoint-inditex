package com.inditex.eavila.api.models.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceResponse implements Serializable {

    private Long prdId;
    private Long brdId;
    private BigDecimal rtsApply;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

}
