package com.datacenter.recargas.infrastructure.adapter;

import com.datacenter.recargas.application.port.out.SellerPort;
import com.datacenter.recargas.domain.model.SellerDomain;
import com.datacenter.recargas.infrastructure.adapter.database.repository.JpaSellerRepository;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.SellerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class SellerRepositoryAdapter implements SellerPort {

    private final JpaSellerRepository repository;
    private final SellerMapper sellerMapper;

    public SellerRepositoryAdapter(JpaSellerRepository repository, SellerMapper sellerMapper) {
        this.repository = repository;
        this.sellerMapper = sellerMapper;
    }

    @Override
    public List<SellerDomain> findAllSellers() {
        return repository.findAll()
                .stream()
                .map(sellerMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SellerDomain> findSellerById(Long id) {
        return repository.findById(id)
                .map(sellerMapper::toDomain);
    }
}
