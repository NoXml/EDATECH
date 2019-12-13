package ru.eda.tech.controller.api.update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.eda.tech.controller.api.PathToJsons.PATHTOJASONS;

class EntityUpdateRequestTest {

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        String request = "{\"id\":1,\"name\":\"test\"}";
        String filename = "update/entityUpdateRequest.json";
        String pathToEntityUpdateRequestJson = PATHTOJASONS + filename;

        File requestJson = new File(pathToEntityUpdateRequestJson);
        EntityUpdateRequest entityUpdateRequest = new ObjectMapper()
                .readerFor(EntityUpdateRequest.class)
                .readValue(requestJson);

        assertEquals(1L, entityUpdateRequest.getId());
        assertEquals("test", entityUpdateRequest.getName());
    }

}