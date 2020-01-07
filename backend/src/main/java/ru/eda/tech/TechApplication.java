package ru.eda.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {
        JacksonAutoConfiguration.class
})
public class TechApplication {
    public static void main(String[] args) {
        SpringApplication.run(TechApplication.class, args);
    }
}
