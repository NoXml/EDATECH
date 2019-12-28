package ru.eda.tech.controller.api.read;

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
class EntityReadRequestTest {

    @Value("classpath:/jsons/read/entityReadRequest.json")
    Resource requestJsonResource;

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        assertNotNull(requestJsonResource, "requestJsonResource");

        File requestJsonFile = requestJsonResource.getFile();

        EntityReadRequest entityReadRequest = new ObjectMapper()
                .readerFor(EntityReadRequest.class)
                .readValue(requestJsonFile);

        assertEquals(1L, entityReadRequest.getId());
    }

}