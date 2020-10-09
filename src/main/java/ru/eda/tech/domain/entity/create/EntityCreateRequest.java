package ru.eda.tech.domain.entity.create;

public class EntityCreateRequest {

    private final String name;

    public EntityCreateRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EntityCreateRequest{" +
                "name='" + name + '\'' +
                '}';
    }

}