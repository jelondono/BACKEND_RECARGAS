package com.datacenter.recargas.infrastructure.adapter.web.mapper;

import com.datacenter.recargas.domain.model.OperatorDomain;
import com.datacenter.recargas.domain.model.SellerDomain;
import com.datacenter.recargas.domain.model.TopUpDomain;
import com.datacenter.recargas.infrastructure.adapter.database.entity.OperatorEntity;
import com.datacenter.recargas.infrastructure.adapter.database.entity.SellerEntity;
import com.datacenter.recargas.infrastructure.adapter.database.entity.TopUpEntity;
import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpRequestDTO;
import com.datacenter.recargas.infrastructure.adapter.web.dto.topup.TopUpResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class TopUpMapper {

    /**
     * Convierte un `TopUpRequestDTO` a un `TopUpDomain`.
     *
     * @param dto El objeto `TopUpRequestDTO`.
     * @return El objeto de dominio `TopUpDomain`.
     */
    public TopUpDomain toDomain(TopUpRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return TopUpDomain.builder()
                .amount(dto.getAmount())
                .quantity(dto.getQuantity())
                .operator(dto.getOperatorId() != null ? OperatorDomain.builder().id(dto.getOperatorId()).build() : null)
                .seller(dto.getSellerId() != null ? SellerDomain.builder().id(dto.getSellerId()).build() : null)
                .build();
    }

    /**
     * Convierte un `TopUpDomain` a un `TopUpResponseDTO`.
     *
     * @param domain El objeto `TopUpDomain`.
     * @return El objeto `TopUpResponseDTO`.
     */
    public TopUpResponseDTO toResponseDTO(TopUpDomain domain) {
        if (domain == null) {
            return null;
        }
        return new TopUpResponseDTO(
                domain.getId(),
                domain.getAmount(),
                domain.getQuantity(),
                domain.getOperator() != null ? domain.getOperator().getName() : null,
                domain.getSeller() != null ? domain.getSeller().getName() : null,
                domain.getDate()
        );
    }

    /**
     * Convierte un `TopUpEntity` a un `TopUpDomain`.
     *
     * @param entity El objeto `TopUpEntity`.
     * @return El objeto de dominio `TopUpDomain`.
     */
    public TopUpDomain toDomain(TopUpEntity entity) {
        if (entity == null) {
            return null;
        }
        return TopUpDomain.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .quantity(entity.getQuantity())
                .operator(entity.getOperator() != null ? OperatorDomain.builder()
                        .id(entity.getOperator().getId())
                        .name(entity.getOperator().getName())
                        .image(entity.getOperator().getImage())
                        .build() : null)
                .seller(entity.getSeller() != null ? SellerDomain.builder()
                        .id(entity.getSeller().getId())
                        .name(entity.getSeller().getName())
                        .build() : null)
                .date(entity.getDate())
                .build();
    }

    /**
     * Convierte un `TopUpDomain` a un `TopUpEntity`.
     *
     * @param domain El objeto de dominio `TopUpDomain`.
     * @return El objeto `TopUpEntity`.
     */
    public TopUpEntity toEntity(TopUpDomain domain) {
        if (domain == null) {
            return null;
        }
        TopUpEntity entity = new TopUpEntity();
        entity.setId(domain.getId());
        entity.setAmount(domain.getAmount());
        entity.setQuantity(domain.getQuantity());
        entity.setOperator(domain.getOperator() != null ? new OperatorEntity(
                domain.getOperator().getId(),
                domain.getOperator().getName(),
                domain.getOperator().getImage()
        ) : null);
        entity.setSeller(domain.getSeller() != null ? new SellerEntity(
                domain.getSeller().getId(),
                domain.getSeller().getName()
        ) : null);
        entity.setDate(domain.getDate());
        return entity;
    }
}
