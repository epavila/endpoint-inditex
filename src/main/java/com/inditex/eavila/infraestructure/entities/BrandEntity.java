package com.inditex.eavila.infraestructure.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
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
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BrandEntity implements Serializable {

    private static final long serialVersionUID = 202303230333L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brdId;

    @Column(name = "brd_nombre_cadena")
    private String brdNombreCadena;

    @Version
    private Integer brdVersion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private List<PriceEntity> prices;


}
