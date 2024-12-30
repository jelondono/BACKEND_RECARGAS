package com.datacenter.recargas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TopUpDomain {
    private Long id;
    private BigDecimal amount;
    private Long quantity;
    private OperatorDomain operator;
    private SellerDomain seller;
    private LocalDateTime date;
}
