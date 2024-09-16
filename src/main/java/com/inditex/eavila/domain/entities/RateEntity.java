package com.inditex.eavila.domain.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class RateEntity implements Serializable {

    private static final long serialVersionUID = 202303230340L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rtsId;

    private BigDecimal rtsApply;

    private String rtsDescripcion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "rate", fetch = FetchType.LAZY)
    private List<PriceEntity> prices;

}
