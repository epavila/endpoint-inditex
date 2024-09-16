package com.inditex.eavila.domain.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author eavila
 */
@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 202303230338L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdId;

    private String prdProductName;

    @Version
    private Integer prdVersion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany( mappedBy = "product", fetch = FetchType.LAZY)
    private List<PriceEntity> prices;

}
