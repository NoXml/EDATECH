package ru.eda.tech.domain.enums;

public enum Status {
    CREATED(0),
    CHANGED(1),
    DELETED(2);
    private final Integer id;

    Status(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
