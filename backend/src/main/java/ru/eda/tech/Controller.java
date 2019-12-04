package ru.eda.tech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/status")
    public StatusRepresentation getStatusRepresentation(){
        return new StatusRepresentation(200,"OK","BODY{}");
    }
}
