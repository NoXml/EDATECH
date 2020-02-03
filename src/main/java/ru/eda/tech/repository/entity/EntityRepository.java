package ru.eda.tech.repository.entity;

import ru.eda.tech.domain.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityRepository {
    Entity save(String name);

    Optional<Entity> findById(Long id);

    List<Entity> findAll();

    Optional<Entity> update(Long id, String name);

    Optional<Entity> delete(Long id);
}
