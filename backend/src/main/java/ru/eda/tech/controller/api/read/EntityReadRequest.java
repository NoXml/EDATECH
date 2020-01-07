package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "EntityReadRequest class, which instance contains entity id")
public class EntityReadRequest {

    @ApiModelProperty(notes = "Entity id")
    private Long id;

    @JsonCreator
    public EntityReadRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
