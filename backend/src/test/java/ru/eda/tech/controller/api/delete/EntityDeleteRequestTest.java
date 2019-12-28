package ru.eda.tech.controller.api.delete;

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
class EntityDeleteRequestTest {

    @Value("classpath:/jsons/delete/entityDeleteRequest.json")
    Resource requestJsonResource;

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        assertNotNull(requestJsonResource, "requestJsonResource");

        File requestJsonFile = requestJsonResource.getFile();

        EntityDeleteRequest entityDeleteRequest = new ObjectMapper()
                .readerFor(EntityDeleteRequest.class)
                .readValue(requestJsonFile);

        assertEquals(1L, entityDeleteRequest.getId());
    }

}