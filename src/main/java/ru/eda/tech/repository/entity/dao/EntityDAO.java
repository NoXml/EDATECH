package ru.eda.tech.repository.entity.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "entities")
public class EntityDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entities_generator")
    @SequenceGenerator(name = "entities_generator", sequenceName = "entities_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private Integer status;

    public EntityDAO(String name, Integer status) {
        this.name = name;
        this.status = status;
    }

    public EntityDAO(Long id, String name, Integer status) {
        this(name, status);
        this.id = id;
    }

    protected EntityDAO() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EntityDAO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public EntityDAO setStatus(Integer status) {
        this.status = status;
        return this;
    }

}