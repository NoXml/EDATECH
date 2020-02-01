package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class Response<T> {
    @NotNull
    private final ResponseStatus status;
    @Nullable
    private final T result;
    @Nullable
    private final Error error;

    private Response(@NotNull ResponseStatus status,
                     @Nullable T result,
                     @Nullable Error error) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.error = error;
    }

    @JsonGetter("status")
    public ResponseStatus getStatus() {
        return status;
    }

    @JsonGetter("result")
    public Optional<T> getResult() {
        return Optional.ofNullable(result);
    }

    @JsonGetter("error")
    public Optional<Error> getError() {
        return Optional.ofNullable(error);
    }

    public static Builder status(@NotNull ResponseStatus status) {
        return new Builder()
                .status(status);
    }

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> success(T result) {
        return new Builder()
                .status(ResponseStatus.SUCCESS)
                .build(result);
    }

    public static <T> Response<T> failed(Error error) {
        return new Builder()
                .status(ResponseStatus.FAILED)
                .errorCode(error)
                .build();
    }

    public static <T> Response<T> failed() {
        return failed(null);
    }

    public static class Builder {
        private ResponseStatus status;
        private Error error;

        public Builder status(ResponseStatus status) {
            this.status = status;
            return this;
        }

        public Builder errorCode(Error error) {
            this.error = error;
            return this;
        }

        public <T> Response<T> build() {
            return new Response<>(
                    status,
                    null,
                    error);
        }

        public <T> Response<T> build(T result) {
            return new Response<>(
                    status,
                    result,
                    error);
        }
    }
}
