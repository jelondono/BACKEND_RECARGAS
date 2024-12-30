package com.datacenter.recargas.application.usecase.topup;

import com.datacenter.recargas.application.port.in.topup.CreateTopUpUseCase;
import com.datacenter.recargas.application.port.in.operators.GetOperatorByIdUseCase;
import com.datacenter.recargas.application.port.out.OperatorPort;
import com.datacenter.recargas.application.port.out.SellerPort;
import com.datacenter.recargas.application.port.out.TopUpPort;
import com.datacenter.recargas.application.port.in.sellers.GetSellerByIdUseCase;
import com.datacenter.recargas.domain.model.OperatorDomain;
import com.datacenter.recargas.domain.model.SellerDomain;
import com.datacenter.recargas.domain.model.TopUpDomain;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateTopUpUseCaseImpl implements CreateTopUpUseCase {

    private final TopUpPort topUpPort;
    private final OperatorPort operatorPort;
    private final SellerPort sellerPort;

    public CreateTopUpUseCaseImpl(TopUpPort topUpPort, OperatorPort operatorPort, SellerPort sellerPort) {
        this.topUpPort = topUpPort;
        this.operatorPort = operatorPort;
        this.sellerPort = sellerPort;
    }

    @Override
    public TopUpDomain execute(TopUpDomain topUp) {
        OperatorDomain operator = operatorPort.findById(topUp.getOperator().getId())
                .orElseThrow(() -> new IllegalArgumentException("Operador no encontrado con ID: " + topUp.getOperator().getId()));
        topUp.setOperator(operator);

        SellerDomain seller = sellerPort.findSellerById(topUp.getSeller().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vendedor no encontrado con ID: " + topUp.getSeller().getId()));
        topUp.setSeller(seller);

        topUp.setDate(LocalDateTime.now());
        return topUpPort.saveTopUp(topUp);
    }
}


