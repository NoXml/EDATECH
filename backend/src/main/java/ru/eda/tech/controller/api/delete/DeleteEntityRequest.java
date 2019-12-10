package ru.eda.tech.controller.api.delete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteEntityRequest {

    private Long id;

    @JsonCreator
    public DeleteEntityRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }
}
