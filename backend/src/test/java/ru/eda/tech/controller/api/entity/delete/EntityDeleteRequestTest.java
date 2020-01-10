package ru.eda.tech.controller.api.entity.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EntityDeleteRequestTest {

    @Value("classpath:/data/entity/delete/entityDeleteRequest.json")
    Resource requestJsonResource;

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        File requestJsonFile = requestJsonResource.getFile();

        EntityDeleteRequest entityDeleteRequest = new ObjectMapper()
                .readerFor(EntityDeleteRequest.class)
                .readValue(requestJsonFile);

        assertEquals(1L, entityDeleteRequest.getId());
    }

}