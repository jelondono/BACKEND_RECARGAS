package com.datacenter.recargas.infrastructure.adapter;

import com.datacenter.recargas.application.port.out.OperatorPort;
import com.datacenter.recargas.domain.model.OperatorDomain;
import com.datacenter.recargas.infrastructure.adapter.database.repository.JpaOperatorRepository;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.OperatorMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OperatorRepositoryAdapter implements OperatorPort {

    private final JpaOperatorRepository repository;
    private final OperatorMapper operatorMapper;

    public OperatorRepositoryAdapter(JpaOperatorRepository repository, OperatorMapper operatorMapper) {
        this.repository = repository;
        this.operatorMapper = operatorMapper;
    }

    @Override
    public List<OperatorDomain> getAllOperators() {
        return repository.findAll().stream()
                .map(operatorMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OperatorDomain> findById(Long id) {
        return repository.findById(id)
                .map(operatorMapper::toDomain);
    }
}
