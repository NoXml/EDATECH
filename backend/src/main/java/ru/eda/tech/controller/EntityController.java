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
        return new EntityCreateResponse(1L, "name");
    }

    @GetMapping
    public EntityReadResponse read(@RequestBody EntityReadRequest request) {
        return new EntityReadResponse(1L, "name");
    }

    @PostMapping
    public EntityUpdateResponse update(@RequestBody EntityUpdateRequest request) {
        return new EntityUpdateResponse(1L, "name");
    }

    @DeleteMapping
    public EntityDeleteResponse delete(@RequestBody EntityDeleteRequest request) {
        return new EntityDeleteResponse(1L, "name");
    }
}
