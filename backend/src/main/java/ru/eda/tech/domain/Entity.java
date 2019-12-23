package ru.eda.tech.domain;

import org.springframework.lang.NonNull;
import ru.eda.tech.domain.enums.Status;

import javax.validation.constraints.NotNull;
import java.util.Objects;

public class Entity {
    private Long id;
    private String name;
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
