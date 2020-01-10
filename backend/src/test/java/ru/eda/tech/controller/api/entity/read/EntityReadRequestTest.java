package ru.eda.tech.controller.api.entity.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EntityReadRequestTest {

    @Value("classpath:/data/entity/read/entityReadRequest.json")
    Resource requestJsonResource;

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        File requestJsonFile = requestJsonResource.getFile();

        EntityReadRequest entityReadRequest = new ObjectMapper()
                .readerFor(EntityReadRequest.class)
                .readValue(requestJsonFile);

        assertEquals(1L, entityReadRequest.getId());
    }

}