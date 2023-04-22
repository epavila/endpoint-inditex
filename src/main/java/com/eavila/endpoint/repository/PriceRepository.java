package com.eavila.endpoint.repository;

import com.eavila.endpoint.model.entity.Price;
import com.eavila.endpoint.model.entity.to.PriceTo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(" select new com.eavila.endpoint.model.entity.to.PriceTo(prc.prcId, prc.brand.brdId, prc.rate.rtsApply, " +
            "         prc.startDate, prc.endDate, prc.prcPrice) " +
            "    FROM Price prc " +
            "    WHERE prc.product.prdId = :idProduct " +
            "    AND prc.brand.brdId = :idBrand " +
            "    AND prc.startDate <= :applicationDate " +
            "    AND prc.endDate >= :applicationDate " +
            " order by prc.priority desc ")
    Page<PriceTo> findCurrentPrice(@Param("applicationDate") LocalDateTime applicationDate,
                                   @Param("idProduct") Long idProduct,
                                   @Param("idBrand") Long idBrand, Pageable pageable);

}
