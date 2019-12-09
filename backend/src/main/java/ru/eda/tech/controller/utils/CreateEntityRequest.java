package ru.eda.tech.controller.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEntityRequest {
    @JsonProperty("name")
    private String name;

    public CreateEntityRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
