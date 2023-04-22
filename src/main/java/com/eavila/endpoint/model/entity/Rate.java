package com.eavila.endpoint.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author eavila
 */
//@Table
@Entity
@Table(name = "rates")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Rate implements Serializable {

    private static final long serialVersionUID = 202303230340L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rtsId;

    private BigDecimal rtsApply;

    private String rtsDescripcion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "rate",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Price> prices;

}
