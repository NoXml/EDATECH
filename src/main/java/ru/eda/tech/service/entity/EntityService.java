package ru.eda.tech.service.entity;

import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;

import java.util.List;

public interface EntityService {

    ResponseContent<EntityCreateResponse> create(EntityCreateRequest request);

    ResponseContent<EntityReadResponse> read(Long id);

    ResponseContent<List<EntityReadResponse>> readAll();

    ResponseContent<EntityUpdateResponse> update(EntityUpdateRequest request);

    ResponseContent<EntityDeleteResponse> delete(Long id);
}
