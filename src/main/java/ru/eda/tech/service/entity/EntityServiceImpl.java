package ru.eda.tech.service.entity;

import org.springframework.stereotype.Service;
import ru.eda.tech.controller.api.Error;
import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.repository.entity.EntityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityRepository entityRepository;

    public EntityServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public ResponseContent<EntityCreateResponse> create(EntityCreateRequest request) {
        String name = request.getName();
        Entity entity = entityRepository.save(name);
        if (entity == null) {
            return ResponseContent.failed(Error.of("EntityNotSaved", "Entity was not saved!"));
        }
        return ResponseContent.success(new EntityCreateResponse(entity.getId(), entity.getName()));
    }

    @Override
    public ResponseContent<EntityReadResponse> read(Long id) {
        return entityRepository.findById(id)
                .map(entity -> ResponseContent.success(new EntityReadResponse(entity.getId(), entity.getName())))
                .orElse(ResponseContent.failed(Error.of("EntityNotFound", "Entity was not found!")));
    }

    @Override
    public ResponseContent<List<EntityReadResponse>> readAll() {
        List<EntityReadResponse> entityReadResponses = entityRepository.findAll()
                .stream()
                .map(entity -> new EntityReadResponse(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
        return ResponseContent.success(entityReadResponses);
    }

    @Override
    public ResponseContent<EntityUpdateResponse> update(EntityUpdateRequest request) {
        return entityRepository.update(request.getId(), request.getName())
                .map(entity -> ResponseContent.success(new EntityUpdateResponse(entity.getId(), entity.getName())))
                .orElse(ResponseContent.failed(Error.of("EntityNotUpdated", "Entity was not update!")));
    }

    @Override
    public ResponseContent<EntityDeleteResponse> delete(Long id) {
        return entityRepository.delete(id)
                .map(entity -> ResponseContent.success(new EntityDeleteResponse(entity.getId(), entity.getName())))
                .orElse(ResponseContent.failed(Error.of("EntityNotDeleted", "Entity was not delete!")));
    }
}
