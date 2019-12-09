package ru.eda.tech.controller.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadEntityRequest {
    @JsonProperty("id")
    private Long id;

    public ReadEntityRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
