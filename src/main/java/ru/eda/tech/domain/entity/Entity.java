package ru.eda.tech.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;

import java.util.Objects;

@ApiModel(description = "All details about entity")
public class Entity {
    @NonNull
    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @NonNull
    @ApiModelProperty(notes = "Entity name")
    private final String name;

    @NonNull
    @ApiModelProperty(notes = "Entity status")
    private final Status status;

    public Entity(@NonNull Long id, @NonNull String name, @NonNull Status status) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.status = Objects.requireNonNull(status, "status");
    }

    @NonNull
    public Long getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Status getStatus() {
        return status;
    }
}
