package ru.eda.tech.controller.entity.dto.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.tech.domain.entity.Entity;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ApiModel(description = "Entity read response object, which contains response information")
public class EntityReadResponse {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityReadResponse(@Nonnull Long id, @Nonnull String name) {
        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
    }

    @Nonnull
    public static EntityReadResponse of(@Nonnull Entity entity) {
        Objects.requireNonNull(entity, "entity");
        return new EntityReadResponse(entity.getId(), entity.getName());
    }

    @Nonnull
    public static List<EntityReadResponse> of(@Nonnull Collection<Entity> entities) {
        Objects.requireNonNull(entities, "entities");
        return entities.stream()
                .map(EntityReadResponse::of)
                .collect(Collectors.toList());
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