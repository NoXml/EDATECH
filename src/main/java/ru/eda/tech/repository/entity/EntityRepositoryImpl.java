package ru.eda.tech.repository.entity;

import org.springframework.stereotype.Repository;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.domain.entity.Status;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

@Repository
public class EntityRepositoryImpl implements EntityRepository {
    public static final AtomicLong COMMON_ID = new AtomicLong(0L);
    public static final ConcurrentMap<Long, Entity> STORAGE = new ConcurrentHashMap<>();

    private Long generateId() {
        return COMMON_ID.incrementAndGet();
    }

    @Override
    public Entity save(String name) {
        Long id = generateId();
        Entity entity = new Entity(id, name, Status.CREATED);
        STORAGE.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<Entity> findById(Long id) {
        return Optional.ofNullable(STORAGE.get(id))
                .filter(not(entity -> Status.DELETED.equals(entity.getStatus())));
    }

    @Override
    public List<Entity> getAll() {
        return STORAGE.values()
                .stream()
                .filter(not(entity -> Status.DELETED.equals(entity.getStatus())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        return Optional.ofNullable(STORAGE.get(id))
                .filter(not(entity -> Status.DELETED.equals(entity.getStatus())))
                .map(entity -> {
                    Entity updatedEntity = new Entity(entity.getId(), name, Status.CHANGED);
                    STORAGE.put(updatedEntity.getId(), updatedEntity);
                    return updatedEntity;
                });
    }

    @Override
    public Optional<Entity> deleteById(Long id) {
        return Optional.ofNullable(STORAGE.get(id))
                .filter(not(entity -> Status.DELETED.equals(entity.getStatus())))
                .map(entity -> {
                    Entity deletedEntity = new Entity(entity.getId(), entity.getName(), Status.DELETED);
                    STORAGE.put(deletedEntity.getId(), deletedEntity);
                    return deletedEntity;
                });
    }
}
