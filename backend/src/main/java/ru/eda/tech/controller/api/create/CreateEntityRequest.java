package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateEntityRequest {

    private String name;

    @JsonCreator
    public CreateEntityRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }
}
