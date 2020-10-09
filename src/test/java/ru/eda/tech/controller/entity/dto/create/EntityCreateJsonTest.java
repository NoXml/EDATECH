package ru.eda.tech.controller.entity.dto.create;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;

public class EntityCreateJsonTest extends JsonTestContext {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() {
        EntityCreateRequest entityCreateRequest = new EntityCreateRequest("test");
        shouldDeserialize("EntityCreateRequest.json", entityCreateRequest);
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() {
        EntityCreateResponse entityCreateResponse = new EntityCreateResponse(1L, "test");
        shouldSerialize(entityCreateResponse, "EntityCreateResponse.json");
    }
}