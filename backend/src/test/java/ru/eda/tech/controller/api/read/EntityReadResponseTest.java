package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityReadResponseTest {

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        EntityReadResponse entityReadResponse = new EntityReadResponse(1L, "test");
        String response = new ObjectMapper().writeValueAsString(entityReadResponse);

        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }

}