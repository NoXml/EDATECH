package ru.eda.tech.controller.api.update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateEntityResponseTest {
    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        UpdateEntityResponse readEntityResponse = new UpdateEntityResponse(1l, "test");
        String response = new ObjectMapper().writeValueAsString(readEntityResponse);

        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }
}