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
import ru.eda.tech.controller.api.ResponseBody;
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
    public ResponseBody<EntityCreateResponse> create(
            @ApiParam(value = "Entity create request object", required = true)
            @RequestBody EntityCreateRequest request) {
        EntityCreateResponse entityCreateResponse = entityService.create(request);
        return ResponseBody
                .<EntityCreateResponse>success()
                .buildWith(entityCreateResponse);
    }

    @GetMapping
    @ApiOperation("Read all entities")
    public ResponseBody<List<EntityReadResponse>> readAll() {
        List<EntityReadResponse> entityReadResponses = entityService.readAll();
        return ResponseBody
                .<List<EntityReadResponse>>success()
                .buildWith(entityReadResponses);
    }

    @GetMapping("/{id}")
    @ApiOperation("Read entity")
    public ResponseBody<EntityReadResponse> read(
            @ApiParam(value = "id of requested Entity to read", required = true)
            @PathVariable("id") Long id) {
        EntityReadResponse entityReadResponse = entityService.read(id);
        return ResponseBody
                .<EntityReadResponse>success()
                .buildWith(entityReadResponse);
    }

    @PutMapping
    @ApiOperation("Update entity")
    public ResponseBody<EntityUpdateResponse> update(
            @ApiParam(value = "Entity update request object", required = true)
            @RequestBody EntityUpdateRequest request) {
        EntityUpdateResponse entityUpdateResponse = entityService.update(request);
        return ResponseBody
                .<EntityUpdateResponse>success()
                .buildWith(entityUpdateResponse);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete entity")
    public ResponseBody<EntityDeleteResponse> delete(
            @ApiParam(value = "id of requested Entity to delete", required = true)
            @PathVariable("id") Long id) {
        EntityDeleteResponse entityDeleteResponse = entityService.delete(id);
        return ResponseBody
                .<EntityDeleteResponse>success()
                .buildWith(entityDeleteResponse);
    }
}


