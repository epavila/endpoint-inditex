package com.inditex.eavila.domain.repositories;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.inditex.eavila.domain.entities.PriceEntity;
import com.inditex.eavila.domain.tos.PriceTo;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(" select new com.inditex.eavila.domain.tos.PriceTo(prc.prcId, prc.brand.brdId, prc.rate.rtsApply, " +
            "         prc.startDate, prc.endDate, prc.prcPrice) " +
            "    FROM PriceEntity prc " +
            "    WHERE prc.product.prdId = :idProduct " +
            "    AND prc.brand.brdId = :idBrand " +
            "    AND prc.startDate <= :applicationDate " +
            "    AND prc.endDate >= :applicationDate " +
            " order by prc.priority desc ")
    Page<PriceTo> findCurrentPrice(@Param("applicationDate") LocalDateTime applicationDate,
                                   @Param("idProduct") Long idProduct,
                                   @Param("idBrand") Long idBrand, Pageable pageable);

}
