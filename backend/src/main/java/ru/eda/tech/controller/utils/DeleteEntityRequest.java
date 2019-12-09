package ru.eda.tech.controller.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteEntityRequest {
    @JsonProperty("id")
    private Long id;

    public DeleteEntityRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
