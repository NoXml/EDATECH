package ru.eda.tech.repository.entity.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.eda.tech.repository.entity.dao.EntityDAO;

@Repository
public interface EntityRepositoryJpa extends CrudRepository<EntityDAO, Long> {

}