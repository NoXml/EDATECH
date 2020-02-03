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
    private static final AtomicLong COMMON_ID = new AtomicLong(0L);
    private static final ConcurrentMap<String, Entity> STORAGE = new ConcurrentHashMap<>();

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
        return Optional.ofNullable(STORAGE.get(id.toString()));
    }

    @Override
    public List<Entity> findAll() {
        return STORAGE.values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        return Optional.ofNullable(STORAGE.get(id.toString()))
                .flatMap(entity -> {
                    Entity newEntity = new Entity(entity.getId(), name, Status.CHANGED); //надо сделать походу сеттеры для name и для Status
                    STORAGE.put(newEntity.getId().toString(), newEntity);
                    return Optional.of(newEntity);
                });
    }

    @Override
    public Optional<Entity> delete(Long id) {
        return Optional.ofNullable(STORAGE.remove(id.toString()));
    }
}
