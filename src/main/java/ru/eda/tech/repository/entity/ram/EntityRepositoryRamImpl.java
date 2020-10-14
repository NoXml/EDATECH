package ru.eda.tech.repository.entity.ram;

import org.springframework.stereotype.Repository;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.repository.entity.EntityRepository;
import ru.eda.tech.repository.entity.dao.EntityDAO;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static ru.eda.tech.domain.entity.Status.CHANGED;
import static ru.eda.tech.domain.entity.Status.DELETED;
import static ru.eda.tech.repository.entity.dao.Utils.ENTITY_MAPPER;
import static ru.eda.tech.repository.entity.dao.Utils.NOT_DELETED;

@Repository
public class EntityRepositoryRamImpl implements EntityRepository {

    public static final AtomicLong COMMON_ID = new AtomicLong(1L);
    public static final ConcurrentMap<Long, EntityDAO> STORAGE = new ConcurrentHashMap<>();

    private Long generateId() {
        return COMMON_ID.getAndIncrement();
    }

    @Override
    public Entity save(String name) {
        var id = generateId();
        var dao = new EntityDAO(id, name, CHANGED.getId());
        STORAGE.put(dao.getId(), dao);
        return ENTITY_MAPPER.apply(dao);
    }

    @Override
    public Optional<Entity> findById(Long id) {
        return Optional.ofNullable(STORAGE.get(id))
                .filter(NOT_DELETED)
                .map(ENTITY_MAPPER);
    }

    @Override
    public List<Entity> getAll() {
        return STORAGE.values().stream()
                .filter(NOT_DELETED)
                .map(ENTITY_MAPPER)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        return Optional.ofNullable(STORAGE.get(id))
                .filter(NOT_DELETED)
                .map(dao -> {
                    STORAGE.put(dao.getId(), dao.setName(name).setStatus(CHANGED.getId()));
                    return dao;
                })
                .map(ENTITY_MAPPER);
    }

    @Override
    public Optional<Entity> deleteById(Long id) {
        return Optional.ofNullable(STORAGE.get(id))
                .filter(NOT_DELETED)
                .map(dao -> {
                    STORAGE.put(dao.getId(), dao.setStatus(DELETED.getId()));
                    return dao;
                })
                .map(ENTITY_MAPPER);
    }

}