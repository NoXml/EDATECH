package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ResponseContent<T> {
    @NotNull
    private final Status status;
    @NotNull
    private final T result;
    @Nullable
    private final ErrorCode errorCode;

    private ResponseContent(@NotNull Status status,
                            @Nullable T result,
                            @Nullable ErrorCode errorCode) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.errorCode = errorCode;
    }

    @JsonGetter("status")
    public Status getStatus() {
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

    public static <T> Builder<T> status(@NotNull Status status) {
        return new Builder<T>()
                .status(status);
    }

    public static <T> Builder<T> success() {
        return new Builder<T>()
                .status(Status.SUCCESS);
    }

    public static <T> Builder<T> failed() {
        return new Builder<T>()
                .status(Status.FAILED);
    }

    public static class Builder<T> {
        private Status status;
        private T result;
        private ErrorCode errorCode;

        public Builder<T> status(Status status) {
            this.status = status;
            return this;
        }

        public Builder<T> errorCode(String value, String message) {
            this.errorCode = new ErrorCode(value, message);
            return this;
        }

        public ResponseContent<T> build() {
            return new ResponseContent<>(
                    status,
                    result,
                    errorCode);
        }

        public ResponseContent<T> buildWith(T result) {
            return new ResponseContent<>(
                    status,
                    result,
                    errorCode);
        }
    }
}
