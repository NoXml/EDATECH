package ru.eda.tech.controller.api.update;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityUpdateResponseTest {
    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        EntityUpdateResponse entityUpdateResponse = new EntityUpdateResponse(1L, "test");
        String response = new ObjectMapper().writeValueAsString(entityUpdateResponse);

        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }
}