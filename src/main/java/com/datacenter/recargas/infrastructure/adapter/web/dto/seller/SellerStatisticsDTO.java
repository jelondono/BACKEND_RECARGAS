package com.datacenter.recargas.infrastructure.adapter.web.dto.seller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerStatisticsDTO {
    private Long id;
    private String sellerName;
    private Long totalQuantity;
    private BigDecimal totalAmount;


}
