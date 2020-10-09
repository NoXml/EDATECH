package ru.eda.tech.controller.entity.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(description = "Entity create request object, which contains request information")
public class EntityCreateRequestDTO {

    @NotBlank
    @Size(max = 32)
    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityCreateRequestDTO(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EntityCreateRequestDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}