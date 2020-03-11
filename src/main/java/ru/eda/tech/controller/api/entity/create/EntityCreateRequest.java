package ru.eda.tech.controller.api.entity.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "Entity create request object, which contains request information")
public class EntityCreateRequest {

    @NotBlank
    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityCreateRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
