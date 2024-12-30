package com.datacenter.recargas.infrastructure.adapter.web.dto.operator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatorStatisticsDTO {
    private Long  operatorId;
    private String operatorName;
    private Long totalQuantity;
    private BigDecimal totalAmount;


}
