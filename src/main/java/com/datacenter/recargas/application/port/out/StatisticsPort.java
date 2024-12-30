package com.datacenter.recargas.application.port.out;

import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorStatisticsDTO;
import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerStatisticsDTO;
import java.util.List;

public interface StatisticsPort {

    /**
     * Obtiene estadísticas agrupadas por operador.
     *
     * @return Una lista de estadísticas por operador.
     */
    List<OperatorStatisticsDTO> getStatisticsByOperator();

    /**
     * Obtiene estadísticas agrupadas por vendedor.
     *
     * @return Una lista de estadísticas por vendedor.
     */
    List<SellerStatisticsDTO> getStatisticsBySeller();
}
