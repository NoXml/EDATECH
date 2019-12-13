package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static ru.eda.tech.controller.api.PathToJsons.PATHTOJASONS;

class EntityCreateRequestTest {

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {

        String filename = "create/entityCreateRequest.json";
        String pathToEntityCreateRequestJson = PATHTOJASONS + filename;

        File requestJson = new File(pathToEntityCreateRequestJson);
        EntityCreateRequest entityCreateRequest = new ObjectMapper()
                .readerFor(EntityCreateRequest.class)
                .readValue(requestJson);

        assertEquals("test", entityCreateRequest.getName());
    }
}