package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.springframework.lang.NonNull;

import java.util.Objects;

public final class Error {
    @NonNull
    private final String code;
    @NonNull
    private final String message;

    private Error(@NonNull String code, @NonNull String message) {
        this.code = Objects.requireNonNull(code, "code");
        this.message = Objects.requireNonNull(message, "message");
    }

    @NonNull
    public static Error of(@NonNull String code, @NonNull String message) {
        return new Error(code, message);
    }

    @NonNull
    @JsonGetter("code")
    public String getCode() {
        return code;
    }

    @NonNull
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
