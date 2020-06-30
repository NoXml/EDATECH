package ru.eda.tech.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @ApiOperation("Get backend status state")
    @GetMapping("/status")
    @CrossOrigin(origins = "*")  // TODO: For development and testing only. Remove for production.
    public String getStatus() {
        return "";
    }
}
