package ru.eda.tech.service.entity;

import org.springframework.stereotype.Service;
import ru.eda.tech.controller.api.Error;
import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteRequest;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteResponse;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.repository.entity.EntityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityRepository entityRepository;

    public EntityServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public Entity create(String name) {
        return entityRepository.save(name);
    }

    @Override
    public Optional<Entity> read(Long id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<Entity> readAll() {
        return entityRepository.getAll();
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        return entityRepository.update(id, name);
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