package ru.eda.tech.controller.api.update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateEntityRequestTest {

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws JsonProcessingException {
        String request = "{\"id\":1,\"name\":\"test\"}";
        UpdateEntityRequest updateEntityRequest = new ObjectMapper()
                .readerFor(UpdateEntityRequest.class)
                .readValue(request);
        assertEquals(1, updateEntityRequest.getId());
        assertEquals("test", updateEntityRequest.getName());
    }

}