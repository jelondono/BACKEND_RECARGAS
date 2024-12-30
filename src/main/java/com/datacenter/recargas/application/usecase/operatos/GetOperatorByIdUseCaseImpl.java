package com.datacenter.recargas.application.usecase.operatos;

import com.datacenter.recargas.application.port.in.operators.GetOperatorByIdUseCase;
import com.datacenter.recargas.application.port.out.OperatorPort;
import com.datacenter.recargas.domain.model.OperatorDomain;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetOperatorByIdUseCaseImpl implements GetOperatorByIdUseCase {

    private final OperatorPort operatorPort;

    public GetOperatorByIdUseCaseImpl(OperatorPort operatorPort) {
        this.operatorPort = operatorPort;
    }

    @Override
    public Optional<OperatorDomain> execute(Long id) {
        return operatorPort.findById(id);
    }
}
