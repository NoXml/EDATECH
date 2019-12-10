package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class CreateEntityRequestTest {

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws JsonProcessingException {
        String request = "{\"name\":\"test\"}";
        CreateEntityRequest createEntityRequest = new ObjectMapper()
                .readerFor(CreateEntityRequest.class)
                .readValue(request);
        assertEquals("test", createEntityRequest.getName());
    }
}