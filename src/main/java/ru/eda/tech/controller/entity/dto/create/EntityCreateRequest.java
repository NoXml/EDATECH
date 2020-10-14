package ru.eda.tech.controller.entity.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@ApiModel(description = "Entity create request object, which contains request information")
public class EntityCreateRequest {

    @NotBlank
    @Size(max = 32)
    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityCreateRequest(@JsonProperty("name") String name) {
        this.name = name;
    }

    @Nonnull
    public String getName() {
        return Objects.requireNonNull(name, "name");
    }

    @Override
    public String toString() {
        return "EntityCreateRequest{" +
                "name='" + name + '\'' +
                '}';
    }

}