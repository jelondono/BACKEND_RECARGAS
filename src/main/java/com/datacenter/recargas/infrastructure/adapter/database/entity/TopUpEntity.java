package com.datacenter.recargas.infrastructure.adapter.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "topup")
public class TopUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    private Long quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    private OperatorEntity operator;

    @ManyToOne(fetch = FetchType.EAGER)
    private SellerEntity seller;

    private LocalDateTime date;
}
