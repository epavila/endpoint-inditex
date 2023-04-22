package com.eavila.endpoint.model.entity;

import com.eavila.endpoint.utils.enums.PriorityPriceEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author eavila
 */
@Entity
@Table(name = "prices")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Price implements Serializable {

    private static final long serialVersionUID = 202303230350L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prcId;

    @ManyToOne
    @JoinColumn(name = "brd_id", nullable = false)
    private Brand brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "rts_id", nullable = false)
    private Rate rate;

    @ManyToOne
    @JoinColumn(name = "prd_id", nullable = false)
    private Product product;


    @Enumerated(EnumType.ORDINAL)
    private PriorityPriceEnum priority;

    private BigDecimal prcPrice;

    private String curr;
}
