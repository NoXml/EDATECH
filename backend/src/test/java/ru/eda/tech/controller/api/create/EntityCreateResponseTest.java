package ru.eda.tech.controller.api.create;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityCreateResponseTest {

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        EntityCreateResponse entityCreateResponse = new EntityCreateResponse(1L, "test");
        String response = new ObjectMapper().writeValueAsString(entityCreateResponse);
        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }
}