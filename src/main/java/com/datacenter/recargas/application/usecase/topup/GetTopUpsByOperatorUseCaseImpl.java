package com.datacenter.recargas.application.usecase.topup;

import com.datacenter.recargas.application.port.in.topup.GetTopUpsByOperatorUseCase;
import com.datacenter.recargas.application.port.out.TopUpPort;
import com.datacenter.recargas.domain.model.TopUpDomain;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetTopUpsByOperatorUseCaseImpl implements GetTopUpsByOperatorUseCase {

    private final TopUpPort topUpPort;

    public GetTopUpsByOperatorUseCaseImpl(TopUpPort topUpPort) {
        this.topUpPort = topUpPort;
    }

    @Override
    public List<TopUpDomain> execute(Long operatorId) {
        return topUpPort.findByOperatorId(operatorId);
    }
}

