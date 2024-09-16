package com.inditex.eavila.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.inditex.eavila.utils.enums.PriorityPriceEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author eavila
 */
@Entity
@Table(name = "prices")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PriceEntity implements Serializable {

    private static final long serialVersionUID = 202303230350L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prcId;

    @ManyToOne
    @JoinColumn(name = "brd_id", nullable = false)
    private BrandEntity brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "rts_id", nullable = false)
    private RateEntity rate;

    @ManyToOne
    @JoinColumn(name = "prd_id", nullable = false)
    private ProductEntity product;


    @Enumerated(EnumType.ORDINAL)
    private PriorityPriceEnum priority;

    private BigDecimal prcPrice;

    private String curr;
}
