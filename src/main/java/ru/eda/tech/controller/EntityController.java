package ru.eda.tech.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteRequest;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
import ru.eda.tech.controller.api.entity.read.EntityReadRequest;
import ru.eda.tech.controller.api.entity.read.EntityReadResponse;
import ru.eda.tech.controller.api.entity.update.EntityUpdateRequest;
import ru.eda.tech.controller.api.entity.update.EntityUpdateResponse;
import ru.eda.tech.service.entity.EntityService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entity")
public class EntityController {

    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping
    @ApiOperation("Create entity")
    public ResponseContent<EntityCreateResponse> create(
            @ApiParam(value = "Entity create request object", required = true)
            @Valid @RequestBody EntityCreateRequest request) {
        return entityService.create(request);
    }

    @GetMapping("/{id}")
    @ApiOperation("Read entity")
    public ResponseContent<EntityReadResponse> read(
            @ApiParam(value = "id of requested Entity to read", required = true)
            @PathVariable("id") Long id) {
        return entityService.read(new EntityReadRequest(id));
    }

    @GetMapping
    @ApiOperation("Read all entities")
    public ResponseContent<List<EntityReadResponse>> readAll() {
        return entityService.readAll();
    }

    @PutMapping
    @ApiOperation("Update entity")
    public ResponseContent<EntityUpdateResponse> update(
            @ApiParam(value = "Entity update request object", required = true)
            @Valid @RequestBody EntityUpdateRequest request) {
        return entityService.update(request);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete entity")
    public ResponseContent<EntityDeleteResponse> delete(
            @ApiParam(value = "id of requested Entity to delete", required = true)
            @PathVariable("id") Long id) {
        return entityService.delete(new EntityDeleteRequest(id));
    }
}


