package ru.eda.tech.controller.entity.dto.read;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@ApiModel(description = "Entity read request object, which contains request information")
public class EntityReadRequest {

    @NotNull
    @Positive
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    public EntityReadRequest(@JsonProperty("id") Long id) {
        this.id = id;
    }

    @Nonnull
    public Long getId() {
        return Objects.requireNonNull(id, "id");
    }

}