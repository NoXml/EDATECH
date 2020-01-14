package ru.eda.tech.controller.api.entity.read;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity read request object, which contains request information")
public class EntityReadRequest {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    public EntityReadRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
