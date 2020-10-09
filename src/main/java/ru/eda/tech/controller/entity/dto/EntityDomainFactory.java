package ru.eda.tech.controller.entity.dto;

import ru.eda.tech.controller.entity.dto.create.EntityCreateRequestDTO;
import ru.eda.tech.domain.entity.create.EntityCreateRequest;

public final class EntityDomainFactory {

    private EntityDomainFactory() {

    }

    public static EntityCreateRequest of(EntityCreateRequestDTO dto) {
        return new EntityCreateRequest(dto.getName());
    }

}