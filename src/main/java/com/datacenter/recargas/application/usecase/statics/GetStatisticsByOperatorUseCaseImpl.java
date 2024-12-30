package com.datacenter.recargas.application.usecase.statics;

import com.datacenter.recargas.application.port.in.statics.GetStatisticsByOperatorUseCase;
import com.datacenter.recargas.application.port.out.StatisticsPort;
import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorStatisticsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStatisticsByOperatorUseCaseImpl implements GetStatisticsByOperatorUseCase {

    private final StatisticsPort statisticsPort;

    public GetStatisticsByOperatorUseCaseImpl(StatisticsPort statisticsPort) {
        this.statisticsPort = statisticsPort;
    }

    @Override
    public List<OperatorStatisticsDTO> execute() {
        return statisticsPort.getStatisticsByOperator();
    }
}
