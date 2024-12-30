package com.datacenter.recargas.application.port.in.topup;

import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpResponseDTO;

import java.util.List;

public interface GetTopUpsByOperatorUseCase {
    List<TopUpResponseDTO> execute(Long operatorId);
}
