package ru.eda.tech.service.entity;

import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteRequest;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadRequest;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;

import java.util.List;

public interface EntityService {

    EntityCreateResponse create(EntityCreateRequest request);

    List<EntityReadResponse> readAll();

    EntityReadResponse read(Long id);

    EntityUpdateResponse update(EntityUpdateRequest request);

    EntityDeleteResponse delete(Long id);
}
