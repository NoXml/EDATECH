package ru.eda.tech.controller.api.wrapper;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public enum ResponseStatus {
    SUCCESS("RESPONSE CODE 200"),
    FAILED("RESPONSE CODE NOT 200")
    ;
    private final String id;

    ResponseStatus(@NotNull String id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    public String getId() {
        return id;
    }
}
