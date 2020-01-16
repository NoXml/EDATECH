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
    private final String errorCode;

    private Response(@NotNull ResponseStatus status,
                     @NotNull T result,
                     @Nullable String errorCode) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = Objects.requireNonNull(result, "result");
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
    public String getErrorCode() {
        return errorCode;
    }

    public static <T> Builder<T> of(@NotNull T result) {
        return new Builder<T>()
                .result(result);
    }

    public static <T> Builder<T> success(@NotNull T result) {
        return new Builder<T>()
                .result(result)
                .status(ResponseStatus.SUCCESS);
    }

    public static <T> Builder<T> failed(@NotNull T result) {
        return new Builder<T>()
                .result(result)
                .status(ResponseStatus.FAILED);
    }

    public static class Builder<T> {
        private ResponseStatus status;
        private T result;
        private String errorCode;

        private Builder<T> result(T result) {
            this.result = result;
            return this;
        }

        public Builder<T> status(ResponseStatus status) {
            this.status = status;
            return this;
        }

        public Builder<T> errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Response<T> build() {
            return new Response<>(
                    status,
                    result,
                    errorCode);
        }
    }
}
