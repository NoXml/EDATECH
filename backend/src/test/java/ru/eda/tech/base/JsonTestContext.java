package ru.eda.tech.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.core.ResolvableType;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public abstract class JsonTestContext {

    @Autowired
    private ObjectMapper objectMapper;

    protected void shouldDeserialize(String srcJsonFilename, Object expectedObject) {
        JacksonTester<Object> tester = new JacksonTester<>(
                getClass(), ResolvableType.forClass(expectedObject.getClass()), objectMapper);
        Object objectDeserialized = null;
        try {
            objectDeserialized = tester.readObject(srcJsonFilename);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Error while reading from: " + srcJsonFilename, e);
        }
        assertThat(objectDeserialized).isEqualToComparingFieldByField(expectedObject);
    }

    protected void shouldSerialize(Object srcObject, String expectedJsonFilename) {
        JacksonTester<Object> tester = new JacksonTester<>(
                getClass(), ResolvableType.forClass(srcObject.getClass()), objectMapper);
        JsonContent<Object> srcJson = null;
        try {
            srcJson = tester.write(srcObject);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Error while getting JsonContent from input object", e);
        }
        assertThat(srcJson).isEqualToJson(expectedJsonFilename);
    }
}
