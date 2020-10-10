package ru.eda.tech.controller.entity;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public enum Errors {

    ENTITY_NOT_FOUND("EntityNotFound", "Entity with id was not found: id=%d");

    private final String code;
    private final String msgTemplate;

    Errors(@NotNull String code, @NotNull String msgTemplate) {
        this.code = Objects.requireNonNull(code, "code");
        this.msgTemplate = Objects.requireNonNull(msgTemplate, "msgTemplate");
    }

    public String getCode() {
        return code;
    }

    public String getMsgTemplate() {
        return msgTemplate;
    }

}