package ru.eda.tech.service.entity;

import org.springframework.stereotype.Service;
import ru.eda.tech.controller.api.Response;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;

import java.util.Collections;
import java.util.List;

@Service
public class EntityServiceImpl implements EntityService {

    @Override
    public Response<EntityCreateResponse> create(EntityCreateRequest request) {
        String name = request.getName();
        EntityCreateResponse entityCreateResponse = new EntityCreateResponse(1L, name);
        return Response
                .success(entityCreateResponse)
                .build();
    }

    @Override
    public Response<List<EntityReadResponse>> readAll() {
        return Response
                .success(Collections.<EntityReadResponse>emptyList())
                .build();
    }

    @Override
    public Response<EntityReadResponse> read(Long id) {
        EntityReadResponse entityReadResponse = new EntityReadResponse(id, "name");
        return Response
                .success(entityReadResponse)
                .build();
    }

    @Override
    public Response<EntityUpdateResponse> update(EntityUpdateRequest request) {
        Long id = request.getId();
        String name = request.getName();
        EntityUpdateResponse entityUpdateResponse = new EntityUpdateResponse(id, name);
        return Response
                .success(entityUpdateResponse)
                .build();
    }

    @Override
    public Response<EntityDeleteResponse> delete(Long id) {
        EntityDeleteResponse entityDeleteResponse = new EntityDeleteResponse(id, "name");
        return Response
                .success(entityDeleteResponse)
                .build();
    }
}
