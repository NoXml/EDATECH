package ru.eda.tech.controller.api.entity.read;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;

public class EntityReadJsonTest extends JsonTestContext {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() {
        EntityReadRequest entityReadRequest = new EntityReadRequest(1L);
        shouldDeserialize("EntityReadRequest.json", entityReadRequest);
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() {
        EntityReadResponse entityReadResponse = new EntityReadResponse(1L, "test");
        shouldSerialize(entityReadResponse, "EntityReadResponse.json");
    }

}