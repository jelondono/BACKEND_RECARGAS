package com.datacenter.recargas.application.usecase.topup;

import com.datacenter.recargas.application.port.in.topup.CreateTopUpUseCase;
import com.datacenter.recargas.application.port.in.operators.GetOperatorByIdUseCase;
import com.datacenter.recargas.application.port.out.TopUpPort;
import com.datacenter.recargas.application.port.in.sellers.GetSellerByIdUseCase;
import com.datacenter.recargas.domain.model.OperatorDomain;
import com.datacenter.recargas.domain.model.SellerDomain;
import com.datacenter.recargas.domain.model.TopUpDomain;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateTopUpUseCaseImpl implements CreateTopUpUseCase {

    private final GetSellerByIdUseCase getSellerByIdUseCase;
    private final GetOperatorByIdUseCase getOperatorByIdUseCase;
    private final TopUpPort topUpRepository;

    public CreateTopUpUseCaseImpl(GetOperatorByIdUseCase getOperatorByIdUseCase, GetSellerByIdUseCase getSellerByIdUseCase, TopUpPort topUpRepository) {
        this.getOperatorByIdUseCase = getOperatorByIdUseCase;
        this.getSellerByIdUseCase = getSellerByIdUseCase;
        this.topUpRepository = topUpRepository;
    }

    @Override
    public TopUpDomain execute(TopUpDomain topUp) {
        OperatorDomain operator = getOperatorByIdUseCase.execute(topUp.getOperator().getId())
                .orElseThrow(() -> new IllegalArgumentException("Operador no encontrado con ID: " + topUp.getOperator().getId()));
        topUp.setOperator(operator);

        SellerDomain seller = getSellerByIdUseCase.execute(topUp.getSeller().getId())
                .orElseThrow(() -> new IllegalArgumentException("Vendedor no encontrado con ID: " + topUp.getSeller().getId()));
        topUp.setSeller(seller);

        topUp.setDate(LocalDateTime.now());

        return topUpRepository.saveTopUp(topUp);
    }

}
