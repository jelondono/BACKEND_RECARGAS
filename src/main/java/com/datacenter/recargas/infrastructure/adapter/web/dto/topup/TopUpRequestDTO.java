package com.datacenter.recargas.infrastructure.adapter.web.dto.topup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopUpRequestDTO {

    private BigDecimal amount;
    private Long quantity;
    private Long operatorId;
    private Long sellerId;
}
