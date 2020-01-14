package ru.eda.tech.controller.api.entity.create;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;

import java.io.IOException;

public class EntityCreateJsonTest extends JsonTestContext {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        EntityCreateRequest entityCreateRequest = new EntityCreateRequest("test");
        shouldDeserialize("EntityCreateRequest.json", entityCreateRequest);
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws Exception {
        EntityCreateResponse entityCreateResponse = new EntityCreateResponse(1L, "test");
        shouldSerialize(entityCreateResponse, "EntityCreateResponse.json");
    }
}