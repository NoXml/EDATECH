package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityReadRequest {

    private Long id;

    @JsonCreator
    public EntityReadRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }
}
