package ru.eda.tech.service.entity;

import ru.eda.tech.controller.api.Response;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;

import java.util.List;

public interface EntityService {

    Response<EntityCreateResponse> create(EntityCreateRequest request);

    Response<List<EntityReadResponse>> readAll();

    Response<EntityReadResponse> read(Long id);

    Response<EntityUpdateResponse> update(EntityUpdateRequest request);

    Response<EntityDeleteResponse> delete(Long id);
}
