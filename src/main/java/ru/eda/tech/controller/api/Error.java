package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class Error {
    @NotNull
    private final String code;
    @NotNull
    private final String message;

    private Error(@NotNull String code, @NotNull String message) {
        this.code = Objects.requireNonNull(code, "code");
        this.message = Objects.requireNonNull(message, "message");
    }

    @NotNull
    public static Error of(@NotNull String code, @NotNull String message) {
        return new Error(code, message);
    }

    @NotNull
    @JsonGetter("code")
    public String getCode() {
        return code;
    }

    @NotNull
    @JsonGetter("message")
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
