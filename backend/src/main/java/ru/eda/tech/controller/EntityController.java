package ru.eda.tech.controller;

import org.springframework.web.bind.annotation.*;
import ru.eda.tech.controller.api.create.CreateEntityRequest;
import ru.eda.tech.controller.api.create.CreateEntityResponse;
import ru.eda.tech.controller.api.delete.DeleteEntityRequest;
import ru.eda.tech.controller.api.delete.DeleteEntityResponse;
import ru.eda.tech.controller.api.read.ReadEntityRequest;
import ru.eda.tech.controller.api.read.ReadEntityResponse;
import ru.eda.tech.controller.api.update.UpdateEntityRequest;
import ru.eda.tech.controller.api.update.UpdateEntityResponse;

@RestController
@RequestMapping("/entity")
public class EntityController {

    @PutMapping
    public CreateEntityResponse createEntity(@RequestBody CreateEntityRequest request) {
        return new CreateEntityResponse(1L, "name");
    }

    @GetMapping
    public ReadEntityResponse readEntity(@RequestBody ReadEntityRequest request) {
        return new ReadEntityResponse(1L, "name");
    }

    @PostMapping
    public UpdateEntityResponse updateEntity(@RequestBody UpdateEntityRequest request) {
        return new UpdateEntityResponse(1L, "name");
    }

    @DeleteMapping
    public DeleteEntityResponse deleteEntity(@RequestBody DeleteEntityRequest request) {
        return new DeleteEntityResponse(1L, "name");
    }
}
