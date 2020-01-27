package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ErrorCode {
    @NotNull
    private final String value;
    @NotNull
    private final String message;

    public ErrorCode(@NotNull String value, @NotNull String message) {
        this.value = Objects.requireNonNull(value, "value");
        this.message = Objects.requireNonNull(message, "message");
    }

    @JsonGetter("value")
    public String getValue() {
        return value;
    }

    @JsonGetter("message")
    public String getMessage() {
        return message;
    }
}
