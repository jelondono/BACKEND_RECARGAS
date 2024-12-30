package com.datacenter.recargas.infrastructure.adapter.database.repository;

import com.datacenter.recargas.infrastructure.adapter.database.entity.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOperatorRepository extends JpaRepository<OperatorEntity, Long> {
}
