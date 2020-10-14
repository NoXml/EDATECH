package ru.eda.tech.controller.entity.dto.read;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.tech.domain.entity.Entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@ApiModel(description = "Entity read response object, which contains response information")
public class EntityReadResponse {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityReadResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EntityReadResponse of(Entity entity) {
        return new EntityReadResponse(entity.getId(), entity.getName());
    }

    public static List<EntityReadResponse> of(Collection<Entity> entities) {
        return entities.stream()
                .map(EntityReadResponse::of)
                .collect(Collectors.toList());
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

}