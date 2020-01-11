package ru.eda.tech.service.entity;

import org.springframework.stereotype.Component;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteRequest;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadRequest;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;

@Component
public class EntityServiceImpl implements EntityService {

    @Override
    public EntityCreateResponse create(EntityCreateRequest request) {
        String name = request.getName();
        return new EntityCreateResponse(1L, name);
    }

    @Override
    public EntityReadResponse read(EntityReadRequest request) {
        Long id = request.getId();
        return new EntityReadResponse(id, "name");
    }

    @Override
    public EntityUpdateResponse update(EntityUpdateRequest request) {
        Long id = request.getId();
        String name = request.getName();
        return new EntityUpdateResponse(id, name);
    }

    @Override
    public EntityDeleteResponse delete(EntityDeleteRequest request) {
        Long id = request.getId();
        return new EntityDeleteResponse(id, "name");
    }
}
