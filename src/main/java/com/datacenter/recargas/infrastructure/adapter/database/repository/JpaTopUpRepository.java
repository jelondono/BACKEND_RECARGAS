package com.datacenter.recargas.infrastructure.adapter.database.repository;

import com.datacenter.recargas.infrastructure.adapter.database.entity.TopUpEntity;
import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorStatisticsDTO;
import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerStatisticsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaTopUpRepository extends JpaRepository<TopUpEntity, Long> {

    @Query("SELECT new com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorStatisticsDTO(" +
            "op.id,op.name, COUNT(t.id), SUM(t.amount)) " +
            "FROM TopUpEntity t JOIN t.operator op GROUP BY op.id, op.name")
    List<OperatorStatisticsDTO> getStatisticsByOperator();

    @Query("SELECT new com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerStatisticsDTO(" +
            "s.id, s.name, COUNT(t.id), SUM(t.amount)) " +
            "FROM TopUpEntity t JOIN t.seller s GROUP BY s.id, s.name")
    List<SellerStatisticsDTO> getStatisticsBySeller();

    List<TopUpEntity> findBySellerId(Long sellerId);

    List<TopUpEntity> findByOperatorId(Long operatorId);
}
