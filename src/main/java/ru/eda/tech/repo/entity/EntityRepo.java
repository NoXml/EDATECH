package ru.eda.tech.repo.entity;

import ru.eda.tech.domain.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityRepo {
    Entity save(String name);

    Optional<Entity> findById(Long id);

    List<Entity> findAll();

    Optional<Entity> update(Long id, String name);

    Optional<Entity> delete(Long id);
}
