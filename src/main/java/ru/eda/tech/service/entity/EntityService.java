package ru.eda.tech.service.entity;

import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteRequest;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteResponse;
import ru.eda.tech.controller.entity.dto.read.EntityReadResponse;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateRequest;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateResponse;
import ru.eda.tech.domain.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityService {

    Entity create(String name);

    Optional<Entity> read(Long id);

    ResponseContent<List<EntityReadResponse>> readAll();

    ResponseContent<EntityUpdateResponse> update(EntityUpdateRequest request);

    ResponseContent<EntityDeleteResponse> delete(EntityDeleteRequest request);
}
