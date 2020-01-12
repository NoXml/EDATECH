package ru.eda.tech.controller.api.entity.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.ResolvableType;
import ru.eda.tech.base.JsonTestContext;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityCreateJsonTest extends JsonTestContext {

    // убрать
    @Autowired
    private JacksonTester<EntityCreateRequest> json;

    // убрать
    @Autowired
    private JacksonTester<EntityCreateResponse> json1;

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {


        EntityCreateResponse entityCreateResponse = new EntityCreateResponse(1L, "test");
        assertThat(json1.write(entityCreateResponse)).isEqualToJson("EntityCreateResponse.json");
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws Exception {

        JacksonTester<EntityCreateRequest> tester = new JacksonTester<>(
                getClass(), ResolvableType.forClass(EntityCreateRequest.class), new ObjectMapper());

//        EntityCreateRequest entityCreateRequest = json.readObject("EntityCreateRequest.json");
        EntityCreateRequest entityCreateRequest = tester.readObject("EntityCreateRequest.json");
        assertThat(entityCreateRequest).isEqualToComparingFieldByField(new EntityCreateRequest("test"));

        // Надо сделать, чтобы компилилось

        shouldSerialize(new EntityCreateRequest("test"), "EntityCreateRequest.json")

        // или так

        shouldSerializeByDefaultFile(new EntityCreateRequest("test"));
    }
}