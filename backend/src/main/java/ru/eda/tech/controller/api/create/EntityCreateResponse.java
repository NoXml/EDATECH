package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityCreateResponse {

    private Long id;

    private String name;

    public EntityCreateResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }
}