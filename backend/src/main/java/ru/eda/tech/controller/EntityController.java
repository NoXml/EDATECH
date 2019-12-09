package ru.eda.tech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eda.tech.controller.utils.*;

@RestController
public class EntityController {

    @PutMapping("/entity")
    public CreateEntityResponse createEntity(@RequestBody CreateEntityRequest request) {
        return new CreateEntityResponse(1L, "name");
    }

    @GetMapping("/entity")
    public ReadEntityResponse readEntity(@RequestBody ReadEntityRequest request) {
        return new ReadEntityResponse(1L, "name");
    }

    @PostMapping("/entity")
    public UpdateEntityResponse updateEntity(@RequestBody UpdateEntityRequest request) {
        return new UpdateEntityResponse(1L, "name");
    }

    @DeleteMapping("/entity")
    public DeleteEntityResponse deleteEntity(@RequestBody DeleteEntityRequest request) {
        return new DeleteEntityResponse(1L, "name");
    }
}
