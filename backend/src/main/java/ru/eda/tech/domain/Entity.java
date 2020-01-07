package ru.eda.tech.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.lang.NonNull;
import ru.eda.tech.domain.enums.Status;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@ApiModel(description = "All details about entity")
public class Entity {
    @ApiModelProperty(notes = "Entity id")
    private Long id;

    @ApiModelProperty(notes = "Entity name")
    private String name;

    @ApiModelProperty(notes = "Entity status")
    private Status status;

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
