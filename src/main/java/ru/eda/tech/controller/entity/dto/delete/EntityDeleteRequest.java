package ru.eda.tech.controller.entity.dto.delete;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@ApiModel(description = "Entity delete request object, which contains request information")
public class EntityDeleteRequest {

    @NotNull
    @Positive
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    public EntityDeleteRequest(@JsonProperty("id") @Nonnull Long id) {
        this.id = Objects.requireNonNull(id, "id");
    }

    @Nonnull
    public Long getId() {
        return id;
    }

}