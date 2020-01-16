package ru.eda.tech.controller.api.wrapper;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Response<T> {
    private final ResponseStatus status;
    private final T result;
    private final String errorCode;

    private Response(@NotNull Builder<T> builder) {
        status = Objects.requireNonNull(builder.status, "status");
        result = Objects.requireNonNull(builder.result, "result");
        errorCode = Objects.requireNonNull(builder.errorCode, "errorCode");
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

    public static <TT> Builder<TT> of(TT result) {
        return new Builder<TT>()
                .result(result);
    }

    public static <TT> Builder<TT> success(TT result) {
        return new Builder<TT>()
                .result(result)
                .status(ResponseStatus.SUCCESS);
    }

    public static <TT> Builder<TT> failed(TT result) {
        return new Builder<TT>()
                .result(result)
                .status(ResponseStatus.FAILED);
    }

    public static class Builder<TTT> {
        private ResponseStatus status;
        private TTT result;
        private String errorCode = "";

        private Builder<TTT> result(TTT result) {
            this.result = result;
            return this;
        }

        public Builder<TTT> status(ResponseStatus status) {
            this.status = status;
            return this;
        }

        public Builder<TTT> errorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Response<TTT> build() {
            return new Response<>(this);
        }
    }
}
