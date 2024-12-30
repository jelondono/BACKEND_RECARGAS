package com.datacenter.recargas.infrastructure.adapter.web.mapper;

import com.datacenter.recargas.domain.model.SellerDomain;
import com.datacenter.recargas.infrastructure.adapter.database.entity.SellerEntity;
import com.datacenter.recargas.infrastructure.adapter.web.dto.seller.SellerResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class SellerMapper {

    /**
     * Convierte un Seller a un SellerResponseDTO.
     *
     * @param seller El objeto de dominio Seller.
     * @return El objeto SellerResponseDTO.
     */
    public SellerResponseDTO toResponseDTO(SellerDomain seller) {
        if (seller == null) {
            return null;
        }
        return new SellerResponseDTO(
                seller.getId(),
                seller.getName()
        );
    }

    /**
     * Convierte un SellerEntity a un Seller.
     *
     * @param entity El objeto de entidad SellerEntity.
     * @return El objeto de dominio Seller.
     */
    public SellerDomain toDomain(SellerEntity entity) {
        if (entity == null) {
            return null;
        }
        return new SellerDomain(
                entity.getId(),
                entity.getName()
        );
    }

    /**
     * Convierte un Seller a un SellerEntity.
     *
     * @param seller El objeto de dominio Seller.
     * @return El objeto de entidad SellerEntity.
     */
    public SellerEntity toEntity(SellerDomain seller) {
        if (seller == null) {
            return null;
        }
        SellerEntity entity = new SellerEntity();
        entity.setId(seller.getId());
        entity.setName(seller.getName());
        return entity;
    }
}
