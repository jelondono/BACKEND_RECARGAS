package com.datacenter.recargas.application.usecase.topup;

import com.datacenter.recargas.application.port.in.topup.GetTopUpsBySellerUseCase;
import com.datacenter.recargas.application.port.out.TopUpPort;
import com.datacenter.recargas.domain.model.TopUpDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTopUpsBySellerUseCaseImpl implements GetTopUpsBySellerUseCase {

    private final TopUpPort topUpPort;

    public GetTopUpsBySellerUseCaseImpl(TopUpPort topUpPort) {
        this.topUpPort = topUpPort;
    }

    @Override
    public List<TopUpDomain> execute(Long sellerId) {
        return topUpPort.findBySellerId(sellerId);
    }
}
