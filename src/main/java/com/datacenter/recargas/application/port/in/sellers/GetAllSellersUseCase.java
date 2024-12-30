package com.datacenter.recargas.application.port.in.sellers;

import com.datacenter.recargas.domain.model.SellerDomain;
import java.util.List;

public interface GetAllSellersUseCase {
    List<SellerDomain> execute();
}
