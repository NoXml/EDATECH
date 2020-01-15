package ru.eda.tech.controller.api.wrapper;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public enum ResponseWrapperStatus {
    SUCCESS(0),
    FAILED(1)
    ;
    private final Integer id;

    ResponseWrapperStatus(@NotNull Integer id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    public Integer getId() {
        return id;
    }
}
