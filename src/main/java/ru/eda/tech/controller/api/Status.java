package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.annotation.Nonnull;
import java.util.Objects;

public enum Status {

    SUCCESS("Success"),
    FAILED("Failed"),
    ;

    private final String id;

    Status(@Nonnull String id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    @Nonnull
    @JsonValue
    public String getId() {
        return id;
    }

}