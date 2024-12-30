package com.datacenter.recargas.application.usecase.topup;

import com.datacenter.recargas.application.port.in.topup.GetTopUpsByOperatorUseCase;
import com.datacenter.recargas.application.port.out.TopUpPort;
import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpResponseDTO;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.TopUpMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetTopUpsByOperatorUseCaseImpl implements GetTopUpsByOperatorUseCase {

    private final TopUpPort topUpRepository;
    private final TopUpMapper topUpMapper;

    public GetTopUpsByOperatorUseCaseImpl(TopUpPort topUpRepository, TopUpMapper topUpMapper) {
        this.topUpRepository = topUpRepository;
        this.topUpMapper = topUpMapper;
    }

    @Override
    public List<TopUpResponseDTO> execute(Long operatorId) {
        return topUpRepository.findByOperatorId(operatorId)
                .stream()
                .map(topUpMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
