package com.datacenter.recargas.infrastructure.adapter;

import com.datacenter.recargas.application.port.out.TopUpPort;
import com.datacenter.recargas.domain.model.TopUpDomain;
import com.datacenter.recargas.infrastructure.adapter.database.entity.TopUpEntity;
import com.datacenter.recargas.infrastructure.adapter.database.repository.JpaTopUpRepository;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.TopUpMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TopUpRepositoryAdapter implements TopUpPort {

    private final JpaTopUpRepository repository;
    private final TopUpMapper mapper;

    public TopUpRepositoryAdapter(JpaTopUpRepository repository, TopUpMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TopUpDomain saveTopUp(TopUpDomain topUp) {
        TopUpEntity entity = mapper.toEntity(topUp);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public List<TopUpDomain> findBySellerId(Long sellerId) {
        return repository.findBySellerId(sellerId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<TopUpDomain> findByOperatorId(Long operatorId) {
        return repository.findByOperatorId(operatorId)
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
