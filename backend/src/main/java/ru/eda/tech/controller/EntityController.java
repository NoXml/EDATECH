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

    @ApiOperation("Create entity")
    @PutMapping
    public EntityCreateResponse create(
            @ApiParam(value = "Entity create request object", required = true)
            @RequestBody EntityCreateRequest request) {
        String name = request.getName();
        return new EntityCreateResponse(1L, name);
    }

    @ApiOperation("Read entity")
    @GetMapping
    public EntityReadResponse read(
            @ApiParam(value = "Entity read request object",required = true)
            @RequestBody EntityReadRequest request) {
        Long id = request.getId();
        return new EntityReadResponse(id, "name");
    }

    @ApiOperation("Update entity")
    @PostMapping
    public EntityUpdateResponse update(
            @ApiParam(value = "Entity update request object", required = true)
            @RequestBody EntityUpdateRequest request) {
        Long id = request.getId();
        String name = request.getName();
        return new EntityUpdateResponse(id, name);
    }

    @ApiOperation("Delete entity")
    @DeleteMapping
    public EntityDeleteResponse delete(
            @ApiParam(value = "Entity delete request object", required = true)
            @RequestBody EntityDeleteRequest request) {
        Long id = request.getId();
        return new EntityDeleteResponse(id, "name");
    }
}


