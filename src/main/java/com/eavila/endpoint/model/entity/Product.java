package com.eavila.endpoint.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @author eavila
 */
@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product implements Serializable {

    private static final long serialVersionUID = 202303230338L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdId;

    private String prdProductName;

    @Version
    private Integer prdVersion;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Price> prices;

}
