package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public enum Status {

    SUCCESS("Success"),
    FAILED("Failed"),
    ;

    private final String id;

    Status(@NotNull String id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    @JsonValue
    public String getId() {
        return id;
    }

}