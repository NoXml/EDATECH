package ru.eda.tech.controller.api.update;

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
class EntityUpdateRequestTest {

    @Value("classpath:/jsons/update/entityUpdateRequest.json")
    Resource requestJsonResource;

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        assertNotNull(requestJsonResource, "requestJsonResource");

        File requestJsonFile = requestJsonResource.getFile();

        EntityUpdateRequest entityUpdateRequest = new ObjectMapper()
                .readerFor(EntityUpdateRequest.class)
                .readValue(requestJsonFile);

        assertEquals(1L, entityUpdateRequest.getId());
        assertEquals("test", entityUpdateRequest.getName());
    }

}