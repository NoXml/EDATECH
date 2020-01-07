package ru.eda.tech.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Info Controller")
public class InfoController {

    @ApiOperation(value = "Get backend status state", response = String.class)
    @GetMapping("/status")
    public String getStatus() {
        return "";
    }
}
