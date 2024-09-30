package com.inditex.eavila.infraestructure.repositories;

import java.time.LocalDateTime;

import com.inditex.eavila.infraestructure.entities.PriceEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(" FROM PriceEntity prc " +
      "    WHERE prc.product.prdId = :idProduct " +
      "    AND prc.brand.brdId = :idBrand " +
      "    AND prc.startDate <= :applicationDate " +
      "    AND prc.endDate >= :applicationDate " +
      " order by prc.priority desc ")
    Page<PriceEntity> findCurrentProductPrice(@Param("applicationDate") LocalDateTime applicationDate,
                                        @Param("idProduct") Long idProduct,
                                        @Param("idBrand") Long idBrand, Pageable pageable);

}
