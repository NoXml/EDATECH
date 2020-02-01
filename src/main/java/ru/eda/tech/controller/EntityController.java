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
import ru.eda.tech.controller.api.Response;
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
    public Response<EntityCreateResponse> create(
            @ApiParam(value = "Entity create request object", required = true)
            @RequestBody EntityCreateRequest request) {
        EntityCreateResponse entityCreateResponse = entityService.create(request);
        return Response.success(entityCreateResponse);
    }

    @GetMapping
    @ApiOperation("Read all entities")
    public Response<List<EntityReadResponse>> readAll() {
        List<EntityReadResponse> entityReadResponses = entityService.readAll();
        return Response.success(entityReadResponses);
    }

    @GetMapping("/{id}")
    @ApiOperation("Read entity")
    public Response<EntityReadResponse> read(
            @ApiParam(value = "id of requested Entity to read", required = true)
            @PathVariable("id") Long id) {
        EntityReadResponse entityReadResponse = entityService.read(id);
        return Response.success(entityReadResponse);
    }

    @PutMapping
    @ApiOperation("Update entity")
    public Response<EntityUpdateResponse> update(
            @ApiParam(value = "Entity update request object", required = true)
            @RequestBody EntityUpdateRequest request) {
        EntityUpdateResponse entityUpdateResponse = entityService.update(request);
        return Response.success(entityUpdateResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete entity")
    public Response<EntityDeleteResponse> delete(
            @ApiParam(value = "id of requested Entity to delete", required = true)
            @PathVariable("id") Long id) {
        EntityDeleteResponse entityDeleteResponse = entityService.delete(id);
        return Response.success(entityDeleteResponse);
    }
}


