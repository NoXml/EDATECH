package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class Response<T> {
    @NotNull
    private final ResponseStatus status;
    @NotNull
    private final T result;
    @Nullable
    private final ErrorCode errorCode;

    private Response(@NotNull ResponseStatus status,
                     @Nullable T result,
                     @Nullable ErrorCode errorCode) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.errorCode = errorCode;
    }

    @JsonGetter("status")
    public ResponseStatus getStatus() {
        return status;
    }

    @JsonGetter("result")
    public T getResult() {
        return result;
    }

    @JsonGetter("errorCode")
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public static <T> Builder<T> status(@NotNull ResponseStatus status) {
        return new Builder<T>()
                .status(status);
    }

    public static <T> Builder<T> success() {
        return new Builder<T>()
                .status(ResponseStatus.SUCCESS);
    }

    public static <T> Builder<T> failed() {
        return new Builder<T>()
                .status(ResponseStatus.FAILED);
    }

    public static class Builder<T> {
        private ResponseStatus status;
        private T result;
        private ErrorCode errorCode;

        public Builder<T> status(ResponseStatus status) {
            this.status = status;
            return this;
        }

        public Builder<T> errorCode(String value, String message) {
            this.errorCode = new ErrorCode(value, message);
            return this;
        }

        public Response<T> build() {
            return new Response<>(
                    this.status,
                    this.result,
                    this.errorCode);
        }

        public Response<T> buildWith(T result) {
            return new Response<>(
                    this.status,
                    result,
                    this.errorCode);
        }
    }
}
