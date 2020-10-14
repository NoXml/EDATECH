package ru.eda.tech.repository.entity.dao;

import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.domain.entity.Status;

import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.function.Predicate.not;
import static ru.eda.tech.domain.entity.Status.DELETED;

public final class Utils {

    public static final Function<EntityDAO, Entity> ENTITY_MAPPER = dao -> new Entity(
            dao.getId(),
            dao.getName(),
            Status.of(dao.getStatus())
    );

    public static final Predicate<EntityDAO> NOT_DELETED = not(dao -> DELETED.getId().equals(dao.getStatus()));

    private Utils() {
    }

}