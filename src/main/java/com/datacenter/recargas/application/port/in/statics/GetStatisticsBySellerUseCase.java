package com.datacenter.recargas.application.port.in.statics;

import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerStatisticsDTO;
import java.util.List;

public interface GetStatisticsBySellerUseCase {
    List<SellerStatisticsDTO> execute();
}
