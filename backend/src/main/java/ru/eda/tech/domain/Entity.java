package ru.eda.tech.domain;

import ru.eda.tech.domain.enums.Status;

public class Entity {
    private long id;
    private String name;
    private Status status;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }
}
