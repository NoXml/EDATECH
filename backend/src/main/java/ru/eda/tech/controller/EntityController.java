package ru.eda.tech.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import ru.eda.tech.controller.api.create.EntityCreateRequest;
import ru.eda.tech.controller.api.create.EntityCreateResponse;
import ru.eda.tech.controller.api.delete.EntityDeleteRequest;
import ru.eda.tech.controller.api.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.read.EntityReadRequest;
import ru.eda.tech.controller.api.read.EntityReadResponse;
import ru.eda.tech.controller.api.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.update.EntityUpdateResponse;

@RestController
@RequestMapping("/entity")
public class EntityController {

    @PutMapping
    public EntityCreateResponse create(@RequestBody EntityCreateRequest request) {
        String name = request.getName();
        return new EntityCreateResponse(1L, name);
    }

    @GetMapping
    public EntityReadResponse read(@RequestBody EntityReadRequest request) {
        Long id = request.getId();
        return new EntityReadResponse(id, "name");
    }

    @PostMapping
    public EntityUpdateResponse update(@RequestBody EntityUpdateRequest request) {
        Long id = request.getId();
        String name = request.getName();
        return new EntityUpdateResponse(id, name);
    }

    @DeleteMapping
    public EntityDeleteResponse delete(@RequestBody EntityDeleteRequest request) {
        Long id = request.getId();
        return new EntityDeleteResponse(id, "name");
    }
}
