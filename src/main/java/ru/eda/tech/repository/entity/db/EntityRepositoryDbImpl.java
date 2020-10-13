package ru.eda.tech.repository.entity.db;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.repository.entity.EntityRepository;
import ru.eda.tech.repository.entity.dao.EntityDAO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static ru.eda.tech.domain.entity.Status.CHANGED;
import static ru.eda.tech.domain.entity.Status.CREATED;
import static ru.eda.tech.domain.entity.Status.DELETED;
import static ru.eda.tech.repository.entity.dao.Utils.ENTITY_MAPPER;
import static ru.eda.tech.repository.entity.dao.Utils.NOT_DELETED;

@Primary
@Repository
public class EntityRepositoryDbImpl implements EntityRepository {

    private final EntityRepositoryJpa entityRepositoryJpa;

    public EntityRepositoryDbImpl(EntityRepositoryJpa entityRepositoryJpa) {
        this.entityRepositoryJpa = entityRepositoryJpa;
    }

    @Override
    public Entity save(String name) {
        return ENTITY_MAPPER.apply(entityRepositoryJpa.save(new EntityDAO(name, CREATED.getId())));
    }

    @Override
    public Optional<Entity> findById(Long id) {
        return entityRepositoryJpa.findById(id)
                .filter(NOT_DELETED)
                .map(ENTITY_MAPPER);
    }

    @Override
    public List<Entity> getAll() {
        return StreamSupport.stream(entityRepositoryJpa.findAll().spliterator(), false)
                .filter(NOT_DELETED)
                .map(ENTITY_MAPPER)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        return entityRepositoryJpa.findById(id)
                .filter(NOT_DELETED)
                .map(dao -> entityRepositoryJpa.save(
                        dao.setName(name).setStatus(CHANGED.getId())))
                .map(ENTITY_MAPPER);
    }

    @Override
    public Optional<Entity> deleteById(Long id) {
        return entityRepositoryJpa.findById(id)
                .filter(NOT_DELETED)
                .map(dao -> entityRepositoryJpa.save(
                        dao.setStatus(DELETED.getId())))
                .map(ENTITY_MAPPER);
    }

}