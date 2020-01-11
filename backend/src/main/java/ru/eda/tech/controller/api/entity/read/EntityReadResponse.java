package ru.eda.tech.controller.api.entity.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity read response object, which contains response information")
public class EntityReadResponse {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityReadResponse(Long id, String name) {
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
