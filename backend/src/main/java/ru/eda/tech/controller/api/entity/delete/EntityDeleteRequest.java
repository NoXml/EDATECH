package ru.eda.tech.controller.api.entity.delete;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity delete request object, which contains request information")
public class EntityDeleteRequest {

    @ApiModelProperty(notes = "Entity id")
    private Long id;

    @JsonCreator
    public EntityDeleteRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
