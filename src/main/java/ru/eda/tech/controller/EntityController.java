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
import ru.eda.tech.controller.api.Error;
import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.controller.api.entity.delete.EntityDeleteResponse;
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

    @PostMapping
    @ApiOperation("Create entity")
    public ResponseContent<EntityCreateResponse> create(
            @ApiParam(value = "Entity create request object", required = true)
            @RequestBody EntityCreateRequest request) {
        EntityCreateResponse entityCreateResponse = entityService.create(request);
        if (entityCreateResponse == null) {
            return ResponseContent.failed(Error.of("Error", "Error Message"));
        }
        return ResponseContent.success(entityCreateResponse);
    }

    @GetMapping
    @ApiOperation("Read all entities")
    public ResponseContent<List<EntityReadResponse>> readAll() {
        List<EntityReadResponse> entityReadResponses = entityService.readAll();
        return ResponseContent.success(entityReadResponses);
    }

    @GetMapping("/{id}")
    @ApiOperation("Read entity")
    public ResponseContent<EntityReadResponse> read(
            @ApiParam(value = "id of requested Entity to read", required = true)
            @PathVariable("id") Long id) {
        EntityReadResponse entityReadResponse = entityService.read(id);
        if (entityReadResponse == null) {
            return ResponseContent.failed(Error.of("Error", "Error Message"));
        }
        return ResponseContent.success(entityReadResponse);
    }

    @PutMapping
    @ApiOperation("Update entity")
    public ResponseContent<EntityUpdateResponse> update(
            @ApiParam(value = "Entity update request object", required = true)
            @RequestBody EntityUpdateRequest request) {
        EntityUpdateResponse entityUpdateResponse = entityService.update(request);
        if (entityUpdateResponse == null) {
            return ResponseContent.failed(Error.of("Error", "Error Message"));
        }
        return ResponseContent.success(entityUpdateResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete entity")
    public ResponseContent<EntityDeleteResponse> delete(
            @ApiParam(value = "id of requested Entity to delete", required = true)
            @PathVariable("id") Long id) {
        EntityDeleteResponse entityDeleteResponse = entityService.delete(id);
        if (entityDeleteResponse == null) {
            return ResponseContent.failed(Error.of("Error", "Error Message"));
        }
        return ResponseContent.success(entityDeleteResponse);
    }
}


