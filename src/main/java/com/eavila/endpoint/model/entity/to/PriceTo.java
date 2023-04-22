package com.eavila.endpoint.model.entity.to;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PriceTo implements Serializable {

    private static final long serialVersionUID = 202303230420L;

    private Long prdId;
    private Long brdId;
    private BigDecimal rtsApply;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal price;

    public PriceTo(Long prdId, Long brdId, BigDecimal rtsApply, LocalDateTime startDate, LocalDateTime endDate, BigDecimal price){
        this.prdId = prdId;
        this.brdId = brdId;
        this.rtsApply = rtsApply;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public PriceTo(Long prdId){
        this.prdId = prdId;
    }

}
