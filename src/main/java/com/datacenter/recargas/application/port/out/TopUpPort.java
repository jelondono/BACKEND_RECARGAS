package com.datacenter.recargas.application.port.out;

import com.datacenter.recargas.domain.model.TopUpDomain;
import java.util.List;

public interface TopUpPort {

    /**
     * Guarda una recarga en el sistema.
     *
     * @param topUp La recarga a guardar.
     * @return La recarga guardada.
     */
    TopUpDomain saveTopUp(TopUpDomain topUp);

    /**
     * Busca recargas por el ID del vendedor.
     *
     * @param sellerId El ID del vendedor.
     * @return Una lista de recargas asociadas al vendedor.
     */
    List<TopUpDomain> findBySellerId(Long sellerId);

    /**
     * Busca recargas por el ID del operador.
     *
     * @param operatorId El ID del operador.
     * @return Una lista de recargas asociadas al operador.
     */
    List<TopUpDomain> findByOperatorId(Long operatorId);
}
