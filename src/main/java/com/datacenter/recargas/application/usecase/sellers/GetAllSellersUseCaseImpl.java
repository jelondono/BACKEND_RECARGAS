package com.datacenter.recargas.application.usecase.sellers;

import com.datacenter.recargas.application.port.in.sellers.GetAllSellersUseCase;
import com.datacenter.recargas.application.port.out.SellerPort;
import com.datacenter.recargas.domain.model.SellerDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetAllSellersUseCaseImpl implements GetAllSellersUseCase {
    private final SellerPort sellerPort;

    @Override
    public List<SellerDomain> execute() {
        return sellerPort.findAllSellers();
    }
}
