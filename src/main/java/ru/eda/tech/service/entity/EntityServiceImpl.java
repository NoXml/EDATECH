package ru.eda.tech.service.entity;

import org.springframework.stereotype.Service;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.repo.entity.EntityRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityRepo entityRepo;

    public EntityServiceImpl(EntityRepo entityRepo) {
        this.entityRepo = entityRepo;
    }

    @Override
    public EntityCreateResponse create(EntityCreateRequest request) {
        String name = request.getName();
        Entity entity = entityRepo.save(name);
        return new EntityCreateResponse(entity.getId(), entity.getName());
    }

    @Override
    public EntityReadResponse read(Long id) {
        Optional<Entity> optionalEntity = entityRepo.findById(id);
        if (optionalEntity.isPresent()) {
            return new EntityReadResponse(optionalEntity.get().getId(), optionalEntity.get().getName());
        }
        return null;
    }

    @Override
    public List<EntityReadResponse> readAll() {
        List<Entity> entities = entityRepo.findAll();
        return entities
                .stream()
                .map(entity -> new EntityReadResponse(entity.getId(), entity.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public EntityUpdateResponse update(EntityUpdateRequest request) {
        Long id = request.getId();
        String name = request.getName();
        Optional<Entity> optionalEntity = entityRepo.update(id, name);
        if (optionalEntity.isPresent()) {
            return new EntityUpdateResponse(optionalEntity.get().getId(), optionalEntity.get().getName());
        }
        return null;
    }

    @Override
    public EntityDeleteResponse delete(Long id) {
        Optional<Entity> optionalEntity = entityRepo.delete(id);
        if (optionalEntity.isPresent()) {
            return new EntityDeleteResponse(optionalEntity.get().getId(), optionalEntity.get().getName());
        }
        return null;
    }
}
