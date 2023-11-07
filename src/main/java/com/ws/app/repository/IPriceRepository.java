package com.ws.app.repository;

import com.ws.app.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface IPriceRepository extends JpaRepository<PriceEntity,Long> {

    @Query(value = "SELECT * FROM price WHERE brand_id = ?1 AND product_id = ?2 " +
            "AND (start_date <= ?3 OR start_date = ?3) AND (end_date >= ?3 OR end_date = ?3) " +
            "ORDER BY priority DESC LIMIT 1", nativeQuery = true)
    List<PriceEntity> findByBrandIdAndProductIdOrderByPriorityDesc(long brandId, long productId, LocalDateTime targetDateTime);
}