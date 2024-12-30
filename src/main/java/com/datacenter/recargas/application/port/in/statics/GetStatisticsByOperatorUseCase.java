package com.datacenter.recargas.application.port.in.statics;

import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorStatisticsDTO;
import java.util.List;

public interface GetStatisticsByOperatorUseCase {
    List<OperatorStatisticsDTO> execute();
}
