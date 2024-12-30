package com.datacenter.recargas.application.port.in.topup;

import com.datacenter.recargas.domain.model.TopUpDomain;
import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpResponseDTO;

import java.util.List;

public interface GetTopUpsByOperatorUseCase {
    List<TopUpDomain> execute(Long operatorId);
}
