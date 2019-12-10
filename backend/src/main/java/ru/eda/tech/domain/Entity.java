package ru.eda.tech.domain;

import ru.eda.tech.domain.enums.Status;

import java.util.Objects;

public class Entity {
    private Long id;
    private String name;
    private Status status;

    public Entity(Long id, String name, Status status) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.status = Objects.requireNonNull(status);
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
