package ru.eda.tech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoEntityController {

    @GetMapping("/")
    public String index() {
        return "";
    }

    @PostMapping("/add")
    public String addDemoEntity() {
        return "";
    }

    @GetMapping("/show")
    public String showDemoEntities() {
        return "";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateDemoEntityForm() {
        return "";
    }

    @PostMapping("/update/{id}")
    public String updateDemoEntity() {
        return "";
    }

    @GetMapping("/delete/{id}")
    public String deleteDemoEntity() {
        return "";
    }


}
