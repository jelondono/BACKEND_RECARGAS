package com.datacenter.recargas.infrastructure.adapter.web.dto.operator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OperatorResponseDTO {
    private Long id;
    private String name;
    private String image;
}
