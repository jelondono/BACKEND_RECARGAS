package com.datacenter.recargas.application.usecase.sellers;

import com.datacenter.recargas.application.port.in.sellers.GetSellerByIdUseCase;
import com.datacenter.recargas.application.port.out.SellerPort;
import com.datacenter.recargas.domain.model.SellerDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetSellerByIdUseCaseImpl implements GetSellerByIdUseCase {
    private final SellerPort sellerPort;

    @Override
    public Optional<SellerDomain> execute(Long id) {
        return sellerPort.findSellerById(id);
    }
}
