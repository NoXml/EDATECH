package ru.eda.tech.repo.entity;

import org.springframework.stereotype.Repository;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.domain.entity.Status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class EntityRepoImpl implements EntityRepo {
    private static final AtomicLong COMMON_ID = new AtomicLong(0L);
    private static final Map<String, Entity> STORAGE = new HashMap<>();

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
        Entity entity = STORAGE.get(id.toString());
        return Optional.ofNullable(entity);
    }

    @Override
    public List<Entity> findAll() {
        return STORAGE
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        Entity entity = STORAGE.get(id.toString());
        if (entity == null) {
            return Optional.empty();
        }
        Entity newEntity = new Entity(entity.getId(), name, Status.CHANGED); //надо сделать походу сеттеры для name и для Status
        STORAGE.put(newEntity.getId().toString(), newEntity);
        return Optional.of(newEntity);
    }

    @Override
    public Optional<Entity> delete(Long id) {
        Entity entity = STORAGE.remove(id.toString());
        if (entity == null) {
            return Optional.empty();
        }
        return Optional.of(entity);
    }
}
