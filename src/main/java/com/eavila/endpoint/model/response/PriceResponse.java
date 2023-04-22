package com.eavila.endpoint.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
