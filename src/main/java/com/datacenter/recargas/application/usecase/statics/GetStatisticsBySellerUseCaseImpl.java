package com.datacenter.recargas.application.usecase.statics;

import com.datacenter.recargas.application.port.in.statics.GetStatisticsBySellerUseCase;
import com.datacenter.recargas.application.port.out.StatisticsPort;
import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerStatisticsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatisticsBySellerUseCaseImpl implements GetStatisticsBySellerUseCase {

    private final StatisticsPort statisticsPort;

    public GetStatisticsBySellerUseCaseImpl(StatisticsPort statisticsPort) {
        this.statisticsPort = statisticsPort;
    }

    @Override
    public List<SellerStatisticsDTO> execute() {
        return statisticsPort.getStatisticsBySeller();
    }
}
