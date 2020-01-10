package ru.eda.tech.controller.api.entity.update;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity update request object, which contains request information")
public class EntityUpdateRequest {

    @ApiModelProperty(notes = "Entity id")
    private Long id;

    @ApiModelProperty(notes = "Entity name")
    private String name;

    @JsonCreator
    public EntityUpdateRequest(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
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
