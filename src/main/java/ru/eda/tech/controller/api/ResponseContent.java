package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class ResponseContent<T> {
    @NotNull
    private final Status status;
    @Nullable
    private final T result;
    @Nullable
    private final Error error;

    private ResponseContent(@NotNull Status status,
                            @Nullable T result,
                            @Nullable Error error) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.error = error;
    }

    @NotNull
    @JsonGetter("status")
    public Status getStatus() {
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

    public static Builder status(@NotNull Status status) {
        return new Builder().status(status);
    }

    public static <T> ResponseContent<T> success(@Nullable T result) {
        return new Builder().status(Status.SUCCESS)
                .build(result);
    }

    public static <T> ResponseContent<T> success() {
        return success(null);
    }

    public static <T> ResponseContent<T> failed(@Nullable Error error) {
        return new Builder().status(Status.FAILED)
                .errorCode(error)
                .build();
    }

    public static <T> ResponseContent<T> failed() {
        return failed(null);
    }

    public static class Builder {
        private Status status;
        private Error error;

        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        public Builder errorCode(Error error) {
            this.error = error;
            return this;
        }

        public <T> ResponseContent<T> build(T result) {
            return new ResponseContent<>(
                    status,
                    result,
                    error);
        }

        public <T> ResponseContent<T> build() {
            return build(null);
        }
    }

    @Override
    public String toString() {
        return "ResponseContent{" +
                "status=" + status +
                ", result=" + result +
                ", error=" + error +
                '}';
    }
}
