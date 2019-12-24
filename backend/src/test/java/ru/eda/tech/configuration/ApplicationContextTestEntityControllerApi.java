package ru.eda.tech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class ApplicationContextTestEntityControllerApi {

    private static final String PATHTOJASONS = "src/main/resources/jsons/";

    @Bean(name = "entityCreateRequest")
    public File entityCreateRequest() {
        String filename = "create/entityCreateRequest.json";
        String pathToEntityCreateRequestJson = PATHTOJASONS + filename;
        File requestJson = new File(pathToEntityCreateRequestJson);
        return requestJson;
    }

    @Bean(name = "entityReadRequest")
    public File entityReadRequest() {
        String filename = "read/entityReadRequest.json";
        String pathToEntityReadRequestJson = PATHTOJASONS + filename;
        File requestJson = new File(pathToEntityReadRequestJson);
        return requestJson;
    }

    @Bean(name = "entityDeleteRequest")
    public File entityDeleteRequest() {
        String filename = "delete/entityDeleteRequest.json";
        String pathToEntityDeleteRequestJson = PATHTOJASONS + filename;
        File requestJson = new File(pathToEntityDeleteRequestJson);
        return requestJson;
    }

    @Bean(name = "entityUpdateRequest")
    public File entityUpdateRequest() {
        String filename = "update/entityUpdateRequest.json";
        String pathToEntityUpdateRequestJson = PATHTOJASONS + filename;
        File requestJson = new File(pathToEntityUpdateRequestJson);
        return requestJson;
    }
}
