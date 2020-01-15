package ru.eda.tech.controller.api.wrapper;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ResponseWrapper<T> {
    private ResponseWrapperStatus status;
    private T result;
    private String errorCode;

    public static class Builder<TT> {
        private final ResponseWrapperStatus status;
        private final TT result;

        private String errorCode = "";

        public Builder(@NotNull ResponseWrapperStatus status, @NotNull TT result) {
            this.status = Objects.requireNonNull(status, "status");
            this.result = Objects.requireNonNull(result, "result");
        }

        public Builder<TT> errorCode(@NotNull String errorCode) {
            this.errorCode = Objects.requireNonNull(errorCode, "errorCode");
            return this;
        }

        public ResponseWrapper<TT> build() {
            return new ResponseWrapper<>(this);
        }
    }

    private ResponseWrapper(@NotNull Builder<T> builder) {
        status = builder.status;
        result = builder.result;
        errorCode = builder.errorCode;
    }

    @JsonGetter("status")
    public ResponseWrapperStatus getStatus() {
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
}
