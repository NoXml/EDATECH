package ru.eda.tech.controller.entity.dto.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Entity create response object, which contains response information")
public class EntityCreateResponseDTO {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityCreateResponseDTO(Long id, String name) {
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

    @Override
    public String toString() {
        return "EntityCreateResponseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}