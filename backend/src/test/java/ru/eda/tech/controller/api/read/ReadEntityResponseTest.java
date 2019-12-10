package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadEntityResponseTest {

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws JsonProcessingException {
        ReadEntityResponse readEntityResponse = new ReadEntityResponse(1l, "test");
        String response = new ObjectMapper().writeValueAsString(readEntityResponse);

        assertEquals("{\"id\":1,\"name\":\"test\"}", response);
    }

}