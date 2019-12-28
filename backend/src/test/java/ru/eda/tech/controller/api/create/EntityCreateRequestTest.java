package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EntityCreateRequestTest {

    @Value("classpath:/jsons/create/entityCreateRequest.json")
    Resource requestJsonResource;

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        assertNotNull(requestJsonResource, "requestJsonResource");

        File requestJsonFile = requestJsonResource.getFile();

        EntityCreateRequest entityCreateRequest = new ObjectMapper()
                .readerFor(EntityCreateRequest.class)
                .readValue(requestJsonFile);

        assertEquals("test", entityCreateRequest.getName());
    }
}