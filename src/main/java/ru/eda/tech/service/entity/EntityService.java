package ru.eda.tech.service.entity;

import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.entity.dto.create.EntityCreateRequest;
import ru.eda.tech.controller.entity.dto.create.EntityCreateResponse;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteRequest;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteResponse;
import ru.eda.tech.controller.entity.dto.read.EntityReadRequest;
import ru.eda.tech.controller.entity.dto.read.EntityReadResponse;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateRequest;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateResponse;

import java.util.List;

public interface EntityService {

    ResponseContent<EntityCreateResponse> create(EntityCreateRequest request);

    ResponseContent<EntityReadResponse> read(EntityReadRequest request);

    ResponseContent<List<EntityReadResponse>> readAll();

    ResponseContent<EntityUpdateResponse> update(EntityUpdateRequest request);

    ResponseContent<EntityDeleteResponse> delete(EntityDeleteRequest request);
}
