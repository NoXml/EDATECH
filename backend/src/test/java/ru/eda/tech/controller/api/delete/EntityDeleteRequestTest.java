package ru.eda.tech.controller.api.delete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.eda.tech.controller.api.PathToJsons.PATHTOJASONS;

class EntityDeleteRequestTest {
    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        String filename = "delete/entityDeleteRequest.json";
        String pathToEntityDeleteRequestJson = PATHTOJASONS + filename;

        File requestJson = new File(pathToEntityDeleteRequestJson);
        EntityDeleteRequest entityDeleteRequest = new ObjectMapper()
                .readerFor(EntityDeleteRequest.class)
                .readValue(requestJson);

        assertEquals(1L, entityDeleteRequest.getId());
    }

}