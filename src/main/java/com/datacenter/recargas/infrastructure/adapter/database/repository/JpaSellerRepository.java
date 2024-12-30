package com.datacenter.recargas.infrastructure.adapter.database.repository;

import com.datacenter.recargas.infrastructure.adapter.database.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSellerRepository extends JpaRepository<SellerEntity, Long> {

}
