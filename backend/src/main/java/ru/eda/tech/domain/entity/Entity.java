package ru.eda.tech.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@ApiModel(description = "All details about entity")
public class Entity {
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    @ApiModelProperty(notes = "Entity status")
    private final Status status;

    public Entity(@NotNull Long id, @NotNull String name, @NotNull Status status) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.status = Objects.requireNonNull(status, "status");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }
}
