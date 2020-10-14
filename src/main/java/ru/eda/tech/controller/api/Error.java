package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.annotation.Nonnull;
import java.util.Objects;

public final class Error {

    @Nonnull
    private final String code;
    @Nonnull
    private final String message;

    private Error(@Nonnull String code, @Nonnull String message) {
        this.code = Objects.requireNonNull(code, "code");
        this.message = Objects.requireNonNull(message, "message");
    }

    @Nonnull
    public static Error of(@Nonnull String code, @Nonnull String message) {
        return new Error(code, message);
    }

    @Nonnull
    @JsonGetter("code")
    public String getCode() {
        return code;
    }

    @Nonnull
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