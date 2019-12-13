package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.eda.tech.controller.api.PathToJsons.PATHTOJASONS;

class EntityReadRequestTest {

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        String filename = "read/entityReadRequest.json";
        String pathToEntityReadRequestJson = PATHTOJASONS + filename;

        File requestJson = new File(pathToEntityReadRequestJson);
        EntityReadRequest entityReadRequest = new ObjectMapper()
                .readerFor(EntityReadRequest.class)
                .readValue(requestJson);

        assertEquals(1L, entityReadRequest.getId());
    }

}