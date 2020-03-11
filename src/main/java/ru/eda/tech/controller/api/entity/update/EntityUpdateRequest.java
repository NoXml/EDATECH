package ru.eda.tech.controller.api.entity.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.NotBlank;

@ApiModel(description = "Entity update request object, which contains request information")
public class EntityUpdateRequest {

    @NotNull
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @NotBlank
    @ApiModelProperty(notes = "Entity name")
    private final String name;

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
