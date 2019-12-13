package ru.eda.tech.controller.api.delete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EntityDeleteRequest {

    private Long id;

    @JsonCreator
    public EntityDeleteRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }
}
