package ru.eda.tech.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = {"Entity Controller"})
public class EntityController {

    @ApiOperation(value = "Create entity with requested name")
    @PutMapping
    public EntityCreateResponse create(
            @ApiParam(value = "Object containing entity name", required = true)
            @RequestBody EntityCreateRequest request) {
        String name = request.getName();
        return new EntityCreateResponse(1L, name);
    }

    @ApiOperation(value = "Read entity by requested id")
    @GetMapping
    public EntityReadResponse read(
            @ApiParam(value = "Object containing entity id",required = true)
            @RequestBody EntityReadRequest request) {
        Long id = request.getId();
        return new EntityReadResponse(id, "name");
    }

    @ApiOperation(value = "Update requested entity")
    @PostMapping
    public EntityUpdateResponse update(
            @ApiParam(value = "Object containing entity id and name", required = true)
            @RequestBody EntityUpdateRequest request) {
        Long id = request.getId();
        String name = request.getName();
        return new EntityUpdateResponse(id, name);
    }

    @ApiOperation(value = "Delete entity by requested id")
    @DeleteMapping
    public EntityDeleteResponse delete(
            @ApiParam(value = "Object containing entity id", required = true)
            @RequestBody EntityDeleteRequest request) {
        Long id = request.getId();
        return new EntityDeleteResponse(id, "name");
    }
}


