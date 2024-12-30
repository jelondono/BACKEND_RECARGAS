package com.datacenter.recargas.application.port.in.topup;

import com.datacenter.recargas.domain.model.TopUpDomain;

public interface CreateTopUpUseCase {
    TopUpDomain execute(TopUpDomain topUp);
}
