package ru.eda.tech.domain.entity.create;

public class EntityCreateResponse {

    private final Long id;

    private final String name;

    public EntityCreateResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EntityCreateResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}