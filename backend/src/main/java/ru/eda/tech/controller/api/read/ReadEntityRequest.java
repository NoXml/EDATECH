package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ReadEntityRequest {

    private Long id;

    @JsonCreator
    public ReadEntityRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }
}
