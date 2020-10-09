package ru.eda.tech.controller.entity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eda.tech.controller.api.ResponseContent;
import ru.eda.tech.controller.entity.dto.EntityDTOFactory;
import ru.eda.tech.controller.entity.dto.EntityDomainFactory;
import ru.eda.tech.controller.entity.dto.create.EntityCreateRequestDTO;
import ru.eda.tech.controller.entity.dto.create.EntityCreateResponseDTO;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteRequest;
import ru.eda.tech.controller.entity.dto.delete.EntityDeleteResponse;
import ru.eda.tech.controller.entity.dto.read.EntityReadRequest;
import ru.eda.tech.controller.entity.dto.read.EntityReadResponse;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateRequest;
import ru.eda.tech.controller.entity.dto.update.EntityUpdateResponse;
import ru.eda.tech.service.entity.EntityService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/entity")
public class EntityController {

    private static final Logger log = LoggerFactory.getLogger(EntityController.class);

    private final EntityService entityService;

    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @PostMapping
    @ApiOperation("Create entity")
    public ResponseContent<EntityCreateResponseDTO> create(
            @ApiParam(value = "Entity create request object", required = true)
            @RequestBody @Valid EntityCreateRequestDTO request) {
        log.info("create(): request={}", request);
        var responseDto = EntityDTOFactory.of(entityService.create(EntityDomainFactory.of(request)));
        var response = ResponseContent.success(responseDto);
        log.info("create(): response={}", response);
        return response;
    }

    @GetMapping("/{id}")
    @ApiOperation("Read entity")
    public ResponseContent<EntityReadResponse> read(
            @ApiParam(value = "id of requested Entity to read", required = true)
            @PathVariable("id") @Positive Long id) {
        log.info("read(): id={}", id);
        ResponseContent<EntityReadResponse> response = entityService.read(new EntityReadRequest(id));
        log.info("read(): response={}", response);
        return response;
    }

    @GetMapping
    @ApiOperation("Read all entities")
    public ResponseContent<List<EntityReadResponse>> readAll() {
        log.info("readAll()");
        ResponseContent<List<EntityReadResponse>> response = entityService.readAll();
        log.info("readAll(): response={}", response);
        return response;
    }

    @PutMapping
    @ApiOperation("Update entity")
    public ResponseContent<EntityUpdateResponse> update(
            @ApiParam(value = "Entity update request object", required = true)
            @RequestBody @Valid EntityUpdateRequest request) {
        log.info("update(): request={}", request);
        ResponseContent<EntityUpdateResponse> response = entityService.update(request);
        log.info("update(): response={}", response);
        return response;
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete entity")
    public ResponseContent<EntityDeleteResponse> delete(
            @ApiParam(value = "id of requested Entity to delete", required = true)
            @PathVariable("id") @Positive Long id) {
        log.info("delete(): id={}", id);
        ResponseContent<EntityDeleteResponse> response = entityService.delete(new EntityDeleteRequest(id));
        log.info("delete(): response={}", response);
        return response;
    }

}