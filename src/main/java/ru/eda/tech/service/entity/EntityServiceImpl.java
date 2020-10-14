package ru.eda.tech.service.entity;

import org.springframework.stereotype.Service;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.repository.entity.EntityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EntityServiceImpl implements EntityService {

    private final EntityRepository entityRepository;

    public EntityServiceImpl(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    @Override
    public Entity create(String name) {
        return entityRepository.save(name);
    }

    @Override
    public Optional<Entity> read(Long id) {
        return entityRepository.findById(id);
    }

    @Override
    public List<Entity> readAll() {
        return entityRepository.getAll();
    }

    @Override
    public Optional<Entity> update(Long id, String name) {
        return entityRepository.update(id, name);
    }

    @Override
    public Optional<Entity> delete(Long id) {
        return entityRepository.deleteById(id);
    }

}