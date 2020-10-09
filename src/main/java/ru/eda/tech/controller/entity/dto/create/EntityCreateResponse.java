package ru.eda.tech.controller.entity.dto.create;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.tech.domain.entity.Entity;

@ApiModel(description = "Entity create response object, which contains response information")
public class EntityCreateResponse {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityCreateResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EntityCreateResponse of(Entity entity) {
        return new EntityCreateResponse(entity.getId(), entity.getName());
    }

    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EntityCreateResponseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}