package ru.eda.tech.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")  // TODO: For development and testing only. Remove for production.
public class InfoController {

    @ApiOperation(value = "Get backend status state")
    @GetMapping("/status")
    public String getStatus() {
        return "";
    }
}
