package ru.eda.tech.controller.api.entity.delete;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel(description = "Entity delete request object, which contains request information")
public class EntityDeleteRequest {

    @NotNull
    @Positive
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    public EntityDeleteRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
