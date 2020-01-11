package ru.eda.tech.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteRequest;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadRequest;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;
import ru.eda.tech.service.entity.EntityService;

@RestController
@RequestMapping("/entity")
public class EntityController {

    EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @ApiOperation("Create entity")
    @PutMapping
    public EntityCreateResponse create(
            @ApiParam(value = "Entity create request object", required = true)
            @RequestBody EntityCreateRequest request) {
        return entityService.create(request);
    }

    @ApiOperation("Read entity")
    @GetMapping
    public EntityReadResponse read(
            @ApiParam(value = "Entity read request object", required = true)
            @RequestBody EntityReadRequest request) {
        return entityService.read(request);
    }

    @ApiOperation("Update entity")
    @PostMapping
    public EntityUpdateResponse update(
            @ApiParam(value = "Entity update request object", required = true)
            @RequestBody EntityUpdateRequest request) {
        return entityService.update(request);
    }

    @ApiOperation("Delete entity")
    @DeleteMapping
    public EntityDeleteResponse delete(
            @ApiParam(value = "Entity delete request object", required = true)
            @RequestBody EntityDeleteRequest request) {
        return entityService.delete(request);
    }
}


