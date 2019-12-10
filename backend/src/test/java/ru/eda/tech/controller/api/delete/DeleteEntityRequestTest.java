package ru.eda.tech.controller.api.delete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEntityRequestTest {
    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws JsonProcessingException {
        String request = "{\"id\":1}";
        DeleteEntityRequest deleteEntityRequest = new ObjectMapper()
                .readerFor(DeleteEntityRequest.class)
                .readValue(request);
        assertEquals(1, deleteEntityRequest.getId());
    }

}