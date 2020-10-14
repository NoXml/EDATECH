package ru.eda.tech.controller.entity.dto.delete;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Nonnull;
import java.util.Objects;

@ApiModel(description = "Entity delete response object, which contains response information")
public class EntityDeleteResponse {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityDeleteResponse(@Nonnull Long id, @Nonnull String name) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
    }

    @Nonnull
    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @Nonnull
    @JsonGetter("name")
    public String getName() {
        return name;
    }

}