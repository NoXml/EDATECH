package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

public class ResponseContent<T> {

    @Nonnull
    private final Status status;
    @Nullable
    private final T result;
    @Nullable
    private final Error error;

    private ResponseContent(@Nonnull Status status,
                            @Nullable T result,
                            @Nullable Error error) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.error = error;
    }

    @Nonnull
    @JsonGetter("status")
    public Status getStatus() {
        return status;
    }

    @Nullable
    @JsonGetter("result")
    public Optional<T> getResult() {
        return Optional.ofNullable(result);
    }

    @Nullable
    @JsonGetter("error")
    public Optional<Error> getError() {
        return Optional.ofNullable(error);
    }

    @Nonnull
    public static Builder status(@Nonnull Status status) {
        return new Builder().status(status);
    }

    @Nonnull
    public static <T> ResponseContent<T> success(@Nullable T result) {
        return new Builder().status(Status.SUCCESS)
                .build(result);
    }

    @Nonnull
    public static <T> ResponseContent<T> success() {
        return success(null);
    }

    @Nonnull
    public static <T> ResponseContent<T> failed(@Nullable Error error) {
        return new Builder().status(Status.FAILED)
                .errorCode(error)
                .build();
    }

    @Nonnull
    public static <T> ResponseContent<T> failed() {
        return failed(null);
    }

    public static class Builder {
        private Status status;
        private Error error;

        @Nonnull
        public Builder status(Status status) {
            this.status = status;
            return this;
        }

        @Nonnull
        public Builder errorCode(Error error) {
            this.error = error;
            return this;
        }

        @Nonnull
        public <T> ResponseContent<T> build(T result) {
            return new ResponseContent<>(
                    status,
                    result,
                    error);
        }

        @Nonnull
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