package ru.eda.tech.controller.api.delete;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteEntityResponseTest {

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        DeleteEntityResponse deleteEntityResponse = new DeleteEntityResponse(1l, "test");
        String response = new ObjectMapper().writeValueAsString(deleteEntityResponse);

        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }

}