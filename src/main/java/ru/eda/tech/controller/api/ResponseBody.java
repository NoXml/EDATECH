package ru.eda.tech.controller.api;

import com.fasterxml.jackson.annotation.JsonGetter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ResponseBody<T> {
    @NotNull
    private final Status status;
    @NotNull
    private final T result;
    @Nullable
    private final ErrorCode errorCode;

    private ResponseBody(@NotNull Status status,
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

        public ResponseBody<T> build() {
            return new ResponseBody<>(
                    status,
                    result,
                    errorCode);
        }

        public ResponseBody<T> buildWith(T result) {
            return new ResponseBody<>(
                    status,
                    result,
                    errorCode);
        }
    }
}
