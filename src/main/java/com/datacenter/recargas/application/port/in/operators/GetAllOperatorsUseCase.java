package com.datacenter.recargas.application.port.in.operators;


import com.datacenter.recargas.domain.model.OperatorDomain;

import java.util.List;

public interface GetAllOperatorsUseCase {
    List<OperatorDomain> execute();
}
