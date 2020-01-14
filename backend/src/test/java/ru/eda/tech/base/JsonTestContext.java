package ru.eda.tech.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.ResolvableType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@JsonTest
public abstract class JsonTestContext {

    @Autowired
    private ObjectMapper objectMapper;

    private JacksonTester<Object> tester;

    protected void shouldDeserialize(String srcJsonFilename, Object expectedObject) throws IOException {
        tester = new JacksonTester<>(
                getClass(), ResolvableType.forClass(expectedObject.getClass()), objectMapper);
        Object objectDeserialized = tester.readObject(srcJsonFilename);
        assertThat(objectDeserialized).isEqualToComparingFieldByField(expectedObject);
    }

    protected void shouldSerialize(Object srcObject, String expectedJsonFilename) throws IOException {
        tester = new JacksonTester<>(
                getClass(), ResolvableType.forClass(srcObject.getClass()), objectMapper);
        assertThat(tester.write(srcObject)).isEqualToJson(expectedJsonFilename);
    }
}
