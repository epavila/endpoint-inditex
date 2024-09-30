package com.inditex.eavila.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductPrice implements Serializable {

  private static final long serialVersionUID = 202303230420L;

  private Long prdId;
  private Long brdId;
  private BigDecimal rtsApply;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private BigDecimal price;

}
