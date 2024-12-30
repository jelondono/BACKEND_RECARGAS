package com.datacenter.recargas.application.port.out;

import com.datacenter.recargas.domain.model.SellerDomain;

import java.util.List;
import java.util.Optional;

public interface SellerPort {
    Optional<SellerDomain> findSellerById(Long id);
    List<SellerDomain> findAllSellers();
}
