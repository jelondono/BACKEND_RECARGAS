package com.datacenter.recargas.application.usecase.operatos;

import com.datacenter.recargas.application.port.in.operators.GetAllOperatorsUseCase;
import com.datacenter.recargas.application.port.out.OperatorPort;
import com.datacenter.recargas.domain.model.OperatorDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllOperatorsUseCaseImpl implements GetAllOperatorsUseCase {
    private final OperatorPort operatorPort;

    @Override
    public List<OperatorDomain> execute() {
        return operatorPort.getAllOperators();
    }
}
