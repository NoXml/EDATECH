package ru.eda.tech.domain.entity;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum Status {

    CREATED(0),
    CHANGED(1),
    DELETED(2),
    ;

    private final Integer id;

    Status(@Nonnull Integer id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    public static Status of(Integer id) {
        return Optional.ofNullable(id)
                .flatMap(requestedId -> Arrays.stream(Status.values())
                        .filter(statusEnum -> statusEnum.getId().equals(requestedId))
                        .findFirst())
                .orElseThrow(() -> new IllegalArgumentException(String.format("Status with id was not found: id=%d", id)));
    }

    public Integer getId() {
        return id;
    }

}