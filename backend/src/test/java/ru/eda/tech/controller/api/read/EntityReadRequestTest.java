package ru.eda.tech.controller.api.read;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.eda.tech.configuration.ApplicationContextTestEntityControllerApi;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(
        loader = AnnotationConfigContextLoader.class,
        classes = ApplicationContextTestEntityControllerApi.class)
class EntityReadRequestTest {

    @Resource(name = "entityReadRequest")
    File requestJson;

    @Test
    void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        assertNotNull(requestJson, "requestJson");

        EntityReadRequest entityReadRequest = new ObjectMapper()
                .readerFor(EntityReadRequest.class)
                .readValue(requestJson);

        assertEquals(1L, entityReadRequest.getId());
    }

}