package ru.eda.tech.controller.api.entity.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity create response object, which contains response information")
public class EntityCreateResponse {

    @ApiModelProperty(notes = "Entity id")
    private Long id;

    @ApiModelProperty(notes = "Entity name")
    private String name;

    public EntityCreateResponse(Long id, String name) {
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
