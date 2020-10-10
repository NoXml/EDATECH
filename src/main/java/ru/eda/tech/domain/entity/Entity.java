package ru.eda.tech.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import java.util.Objects;

@ApiModel(description = "All details about entity")
public class Entity {

    @Nonnull
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @Nonnull
    @ApiModelProperty(notes = "Entity name")
    private final String name;

    @Nonnull
    @ApiModelProperty(notes = "Entity status")
    private final Status status;

    public Entity(@Nonnull Long id, @Nonnull String name, @Nonnull Status status) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.status = Objects.requireNonNull(status, "status");
    }

    @Nonnull
    public Long getId() {
        return id;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    @Nonnull
    public Status getStatus() {
        return status;
    }

}