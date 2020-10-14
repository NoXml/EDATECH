package ru.eda.tech.domain.entity;

import javax.annotation.Nonnull;
import java.util.Objects;

public enum Status {

    CREATED(0),
    CHANGED(1),
    DELETED(2),
    ;

    private final Integer id;

    Status(@Nonnull Integer id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    public Integer getId() {
        return id;
    }

}