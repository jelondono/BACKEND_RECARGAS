package com.datacenter.recargas.application.port.out;

import com.datacenter.recargas.domain.model.OperatorDomain;

import java.util.List;
import java.util.Optional;

public interface OperatorPort {
    List<OperatorDomain> getAllOperators();

    Optional<OperatorDomain> findById(Long id);
}
