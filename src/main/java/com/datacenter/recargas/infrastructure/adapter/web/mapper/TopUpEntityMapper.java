package com.datacenter.recargas.infrastructure.adapter.web.mapper;

import com.datacenter.recargas.domain.model.OperatorDomain;
import com.datacenter.recargas.domain.model.SellerDomain;
import com.datacenter.recargas.domain.model.TopUpDomain;
import com.datacenter.recargas.infrastructure.adapter.database.entity.OperatorEntity;
import com.datacenter.recargas.infrastructure.adapter.database.entity.SellerEntity;
import com.datacenter.recargas.infrastructure.adapter.database.entity.TopUpEntity;

import java.time.LocalDateTime;

public class TopUpEntityMapper {

    public static TopUpEntity toEntity(TopUpDomain topUp) {

        TopUpEntity entity = new TopUpEntity();
        entity.setId(topUp.getId());
        entity.setAmount(topUp.getAmount());
        entity.setQuantity(topUp.getQuantity());
        entity.setDate(topUp.getDate() != null ? topUp.getDate() : LocalDateTime.now());

        if (topUp.getOperator() != null) {
            entity.setOperator(new OperatorEntity(topUp.getOperator().getId(), topUp.getOperator().getName(), topUp.getOperator().getImage()));
        }
        if (topUp.getSeller() != null) {
            entity.setSeller(new SellerEntity(topUp.getSeller().getId(),  topUp.getSeller().getName()));
        }

        return entity;
    }

    public static TopUpDomain toDomain(TopUpEntity entity) {
        return new TopUpDomain(
                entity.getId(),
                entity.getAmount(),
                entity.getQuantity(),
                entity.getOperator() != null
                        ? new OperatorDomain(entity.getOperator().getId(), entity.getOperator().getName(), entity.getOperator().getImage())
                        : null,
                entity.getSeller() != null
                        ? new SellerDomain(entity.getSeller().getId(), entity.getSeller().getName())
                        : null,
                entity.getDate()
        );
    }

}
