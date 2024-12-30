package com.datacenter.recargas.application.port.in.operators;

import com.datacenter.recargas.domain.model.OperatorDomain;

import java.util.Optional;

public interface GetOperatorByIdUseCase {
    Optional<OperatorDomain> execute(Long id);
}
