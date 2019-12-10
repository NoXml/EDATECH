package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadEntityRequestTest {

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws JsonProcessingException {
        String request = "{\"id\":1}";
        ReadEntityRequest readEntityRequest = new ObjectMapper()
                .readerFor(ReadEntityRequest.class)
                .readValue(request);
        assertEquals(1, readEntityRequest.getId());
    }

}