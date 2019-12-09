package ru.eda.tech.domain;

import ru.eda.tech.domain.enums.Status;

public class Entity {
    private Long id;
    private String name;
    private Status status;

    public Entity(Long id, String name, Status status) {
        this.id = id;
        this.name = name;
        this.status = status;
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
