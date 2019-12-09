package ru.eda.tech.controller.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateEntityResponse {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;

    public UpdateEntityResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
