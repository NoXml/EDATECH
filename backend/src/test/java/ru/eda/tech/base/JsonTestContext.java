package ru.eda.tech.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;


@JsonTest
public abstract class JsonTestContext {

    @Autowired
    private ObjectMapper objectMapper;

    protected void shouldSerialize() {

    }

    protected void shouldDeserialize() {

    }
}
