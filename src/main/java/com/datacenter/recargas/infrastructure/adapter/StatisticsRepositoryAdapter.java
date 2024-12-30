package com.datacenter.recargas.infrastructure.adapter;

import com.datacenter.recargas.application.port.out.StatisticsPort;
import com.datacenter.recargas.infrastructure.adapter.database.repository.JpaTopUpRepository;
import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorStatisticsDTO;
import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerStatisticsDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatisticsRepositoryAdapter implements StatisticsPort {

    private final JpaTopUpRepository repository;

    public StatisticsRepositoryAdapter(JpaTopUpRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OperatorStatisticsDTO> getStatisticsByOperator() {
        return repository.getStatisticsByOperator();
    }

    @Override
    public List<SellerStatisticsDTO> getStatisticsBySeller() {
        return repository.getStatisticsBySeller();
    }
}
