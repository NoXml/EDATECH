package ru.eda.tech.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteRequest;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadRequest;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;
import ru.eda.tech.service.entity.EntityService;

import java.util.List;

@RestController
@RequestMapping("/entity")
public class EntityController {

    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @ApiOperation("Create entity")
    @PostMapping
    public EntityCreateResponse create(
            @ApiParam(value = "Entity create request object", required = true)
            @RequestBody EntityCreateRequest request) {
        return entityService.create(request);
    }

    @ApiOperation("Read all entities")
    @GetMapping
    public List<EntityReadResponse> readAll() {
        return entityService.readAll();
    }

    @ApiOperation("Read entity")
    @GetMapping("{id}")
    public EntityReadResponse read(
            @ApiParam(value = "PathVariable id of requested Entity to read", required = true)
            @PathVariable("id") long id) {
        return entityService.read(new EntityReadRequest(id));
    }

    @ApiOperation("Update entity")
    @PutMapping
    public EntityUpdateResponse update(
            @ApiParam(value = "Entity update request object", required = true)
            @RequestBody EntityUpdateRequest request) {
        return entityService.update(request);
    }

    @ApiOperation("Delete entity")
    @DeleteMapping("{id}")
    public EntityDeleteResponse delete(
            @ApiParam(value = "PathVariable id of requested Entity to delete", required = true)
            @PathVariable("id") long id) {
        return entityService.delete(new EntityDeleteRequest(id));
    }
}


