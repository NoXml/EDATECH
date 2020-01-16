package ru.eda.tech.controller.api;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public enum ResponseStatus {
    SUCCESS("Success"),
    FAILED("Failed")
    ;
    private final String id;

    ResponseStatus(@NotNull String id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    public String getId() {
        return id;
    }
}
