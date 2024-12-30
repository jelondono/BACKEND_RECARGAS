package com.datacenter.recargas.infrastructure.adapter.web.dto.topup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopUpResponseDTO {

    private Long id;
    private BigDecimal amount;
    private Long quantity;
    private String operatorName;
    private String sellerName;
    private LocalDateTime date;
}
