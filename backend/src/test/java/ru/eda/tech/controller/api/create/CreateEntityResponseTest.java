package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateEntityResponseTest {

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        CreateEntityResponse createEntityResponse = new CreateEntityResponse(1l, "test");
        String response = new ObjectMapper().writeValueAsString(createEntityResponse);

        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }
}