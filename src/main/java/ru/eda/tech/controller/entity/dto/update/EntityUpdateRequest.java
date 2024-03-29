package ru.eda.tech.controller.entity.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(description = "Entity update request object, which contains request information")
public class EntityUpdateRequest {

    @NotNull
    @Positive
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @NotBlank
    @Size(max = 32)
    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityUpdateRequest(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    @Nonnull
    public Long getId() {
        return Objects.requireNonNull(id, "id");
    }

    @Nonnull
    public String getName() {
        return Objects.requireNonNull(name, "name");
    }

}