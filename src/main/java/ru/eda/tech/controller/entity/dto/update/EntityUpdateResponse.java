package ru.eda.tech.controller.entity.dto.update;

import com.fasterxml.jackson.annotation.JsonGetter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.eda.tech.domain.entity.Entity;

@ApiModel(description = "Entity update response object, which contains response information")
public class EntityUpdateResponse {

    @ApiModelProperty(notes = "Entity id")
    private final Long id;

    @ApiModelProperty(notes = "Entity name")
    private final String name;

    public EntityUpdateResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static EntityUpdateResponse of(Entity entity) {
        return new EntityUpdateResponse(entity.getId(), entity.getName());
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
