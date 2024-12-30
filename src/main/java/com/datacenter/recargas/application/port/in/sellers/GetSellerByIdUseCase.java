package com.datacenter.recargas.application.port.in.sellers;

import com.datacenter.recargas.domain.model.SellerDomain;
import java.util.Optional;

public interface GetSellerByIdUseCase {
    Optional<SellerDomain> execute(Long id);
}
