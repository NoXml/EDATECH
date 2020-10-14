package ru.eda.tech.service.entity;

import ru.eda.tech.domain.entity.Entity;

import java.util.List;
import java.util.Optional;

public interface EntityService {

    Entity create(String name);

    Optional<Entity> read(Long id);

    List<Entity> readAll();

    Optional<Entity> update(Long id, String name);

    Optional<Entity> delete(Long id);

}
