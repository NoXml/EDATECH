package ru.eda.tech.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){
        return ResponseEntity.ok("");
    }
}
