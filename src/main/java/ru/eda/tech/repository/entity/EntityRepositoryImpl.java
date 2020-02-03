package ru.eda.tech.repository.entity;

import org.springframework.stereotype.Repository;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.domain.entity.Status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class EntityRepositoryImpl implements EntityRepository {
    public static final AtomicLong COMMON_ID = new AtomicLong(0L);
    public static final ConcurrentMap<String, Entity> STORAGE = new ConcurrentHashMap<>();

    private Long generateId() {
        return COMMON_ID.incrementAndGet();
    }

    @Override
    public Entity save(String name) {
        Long id = generateId();
        Entity entity = new Entity(id, name, Status.CREATED);
        STORAGE.put(entity.getId().toString(), entity);
        return entity;
    }

    @Override
    public Optional<Entity> findById(Long id) {
        return Optional.ofNullable(STORAGE.get(id.toString()))
                .flatMap(entity -> {
                    if (Status.DELETED.equals(entity.getStatus())) {
                        return Optional.empty();
                    }
                    return Optional.of(entity);
                });
    }

    @Override
    public List<Entity> findAll() {
        return STORAGE.values()
                .stream()
                .filter(entity -> !Status.DELETED.equals(entity.getStatus()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        return Optional.ofNullable(STORAGE.get(id.toString()))
                .flatMap(entity -> {
                    Entity updatedEntity = new Entity(entity.getId(), name, Status.CHANGED);
                    STORAGE.put(updatedEntity.getId().toString(), updatedEntity);
                    return Optional.of(updatedEntity);
                });
    }

    @Override
    public Optional<Entity> delete(Long id) {
        return Optional.ofNullable(STORAGE.get(id.toString()))
                .flatMap(entity -> {
                    Entity deletedEntity = new Entity(entity.getId(), entity.getName(), Status.DELETED);
                    STORAGE.put(deletedEntity.getId().toString(), deletedEntity);
                    return Optional.of(deletedEntity);
                });
    }
}
