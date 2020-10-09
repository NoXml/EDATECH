package ru.eda.tech.controller.entity.dto;

import ru.eda.tech.controller.entity.dto.create.EntityCreateResponseDTO;
import ru.eda.tech.domain.entity.create.EntityCreateResponse;

public final class EntityDTOFactory {

    private EntityDTOFactory() {

    }

    public static EntityCreateResponseDTO of(EntityCreateResponse domain) {
        return new EntityCreateResponseDTO(domain.getId(), domain.getName());
    }

}