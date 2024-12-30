package com.datacenter.recargas.application.usecase.topup;

import com.datacenter.recargas.application.port.in.topup.GetTopUpsBySellerUseCase;
import com.datacenter.recargas.application.port.out.TopUpPort;
import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpResponseDTO;
import com.datacenter.recargas.infrastructure.adapter.web.mapper.TopUpMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetTopUpsBySellerUseCaseImpl implements GetTopUpsBySellerUseCase {

    private final TopUpPort topUpRepository;
    private final TopUpMapper topUpMapper;

    public GetTopUpsBySellerUseCaseImpl(TopUpPort topUpRepository, TopUpMapper topUpMapper) {
        this.topUpRepository = topUpRepository;
        this.topUpMapper = topUpMapper;
    }

    @Override
    public List<TopUpResponseDTO> execute(Long sellerId) {
        return topUpRepository.findBySellerId(sellerId)
                .stream()
                .map(topUpMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
