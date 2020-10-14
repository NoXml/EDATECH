package ru.eda.tech.controller.entity.dto.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.tech.domain.entity.Entity;

import javax.annotation.Nonnull;
import java.util.Objects;

@ApiModel(description = "Entity create response object, which contains response information")
public class EntityCreateResponse {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityCreateResponse(@Nonnull Long id, @Nonnull String name) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
    }

    @Nonnull
    public static EntityCreateResponse of(@Nonnull Entity entity) {
        Objects.requireNonNull(entity, "entity");
        return new EntityCreateResponse(entity.getId(), entity.getName());
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

    @Override
    public String toString() {
        return "EntityCreateResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}