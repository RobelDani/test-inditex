package com.test.inditex.repository;

import com.test.inditex.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

    @Query(value = "SELECT pri FROM Prices pri " +
            "WHERE :dateApplication BETWEEN pri.startDate AND pri.endDate" +
            " AND (:brandId is NULL OR :brandId = pri.brand.id)" +
            " AND (:productId is NULL OR :productId = pri.product.id)")
    List<Prices> findPrices(@Param("dateApplication") LocalDateTime dateApplication,
                            @Param("brandId") Long brandId,
                            @Param("productId") Long productId);
}
