package ru.eda.tech.controller.api.delete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntityDeleteResponseTest {

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        EntityDeleteResponse entityDeleteResponse = new EntityDeleteResponse(1L, "test");
        String response = new ObjectMapper().writeValueAsString(entityDeleteResponse);

        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }

}