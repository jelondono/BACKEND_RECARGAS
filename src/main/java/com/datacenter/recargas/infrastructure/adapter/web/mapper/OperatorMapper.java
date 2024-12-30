package com.datacenter.recargas.infrastructure.adapter.web.mapper;

import com.datacenter.recargas.domain.model.OperatorDomain;
import com.datacenter.recargas.infrastructure.adapter.web.dto.operator.OperatorResponseDTO;
import com.datacenter.recargas.infrastructure.adapter.database.entity.OperatorEntity;
import org.springframework.stereotype.Component;

@Component
public class OperatorMapper {

    /**
     * Convierte un OperatorDomain a un OperatorResponseDTO.
     *
     * @param operator El objeto de dominio OperatorDomain.
     * @return El objeto OperatorResponseDTO.
     */
    public OperatorResponseDTO toResponseDTO(OperatorDomain operator) {
        if (operator == null) {
            return null;
        }
        return new OperatorResponseDTO(
                operator.getId(),
                operator.getName(),
                operator.getImage()
        );
    }

    /**
     * Convierte un OperatorEntity a un OperatorDomain.
     *
     * @param entity El objeto de entidad OperatorEntity.
     * @return El objeto de dominio OperatorDomain.
     */
    public OperatorDomain toDomain(OperatorEntity entity) {
        if (entity == null) {
            return null;
        }
        return new OperatorDomain(
                entity.getId(),
                entity.getName(),
                entity.getImage()
        );
    }

    /**
     * Convierte un OperatorDomain a un OperatorEntity (si es necesario).
     *
     * @param domain El objeto de dominio OperatorDomain.
     * @return El objeto de entidad OperatorEntity.
     */
    public OperatorEntity toEntity(OperatorDomain domain) {
        if (domain == null) {
            return null;
        }
        return new OperatorEntity(
                domain.getId(),
                domain.getName(),
                domain.getImage()
        );
    }
}
