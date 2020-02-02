package ru.eda.tech.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@ApiModel(description = "All details about entity")
public class Entity {
    @NotNull
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @NotNull
    @ApiModelProperty(notes = "Entity name")
    private final String name;

    @NotNull
    @ApiModelProperty(notes = "Entity status")
    private final Status status;

    public Entity(@NotNull Long id, @NotNull String name, @NotNull Status status) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.status = Objects.requireNonNull(status, "status");
    }

    @NotNull
    public Long getId() {
        return id;
    }

    @NotNull
    public String getName() {
        return name;
    }

    @NotNull
    public Status getStatus() {
        return status;
    }
}
