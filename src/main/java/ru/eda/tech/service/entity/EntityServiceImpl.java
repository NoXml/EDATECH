package ru.eda.tech.service.entity;

import org.springframework.stereotype.Service;
import ru.eda.tech.controller.api.Error;
import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteRequest;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteResponse;
import ru.eda.tech.controller.entity.dto.read.EntityReadRequest;
import ru.eda.tech.controller.entity.dto.read.EntityReadResponse;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateRequest;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateResponse;
import ru.eda.tech.domain.entity.create.EntityCreateRequest;
import ru.eda.tech.domain.entity.create.EntityCreateResponse;
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
    public EntityCreateResponse create(EntityCreateRequest request) {
        var name = request.getName();
        var entity = entityRepository.save(name);
        return new EntityCreateResponse(entity.getId(), entity.getName());
    }

    @Override
    public ResponseContent<EntityReadResponse> read(EntityReadRequest request) {
        return entityRepository.findById(request.getId())
                .map(entity -> new EntityReadResponse(entity.getId(), entity.getName()))
                .map(ResponseContent::success)
                .orElseGet(() -> ResponseContent.failed(Error.of("EntityNotFound",
                        String.format("Entity with id was not found: id=%d", request.getId()))));
    }

    @Override
    public ResponseContent<List<EntityReadResponse>> readAll() {
        List<EntityReadResponse> entityReadResponses = entityRepository.getAll().stream()
                .map(entity -> new EntityReadResponse(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
        return ResponseContent.success(entityReadResponses);
    }

    @Override
    public ResponseContent<EntityUpdateResponse> update(EntityUpdateRequest request) {
        return entityRepository.update(request.getId(), request.getName())
                .map(entity -> new EntityUpdateResponse(entity.getId(), entity.getName()))
                .map(ResponseContent::success)
                .orElseGet(() -> ResponseContent.failed(Error.of("EntityNotFound",
                        String.format("Entity with id was not found: id=%d", request.getId()))));
    }

    @Override
    public ResponseContent<EntityDeleteResponse> delete(EntityDeleteRequest request) {
        return entityRepository.deleteById(request.getId())
                .map(entity -> new EntityDeleteResponse(entity.getId(), entity.getName()))
                .map(ResponseContent::success)
                .orElseGet(() -> ResponseContent.failed(Error.of("EntityNotFound",
                        String.format("Entity with id was not found: id=%d", request.getId()))));
    }

}