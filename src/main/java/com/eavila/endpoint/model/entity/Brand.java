package com.eavila.endpoint.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author eavila
 */

@Entity
@Table(name = "brands")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Brand implements Serializable {

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
    @OneToMany(
            mappedBy = "brand",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Price> prices;


}
