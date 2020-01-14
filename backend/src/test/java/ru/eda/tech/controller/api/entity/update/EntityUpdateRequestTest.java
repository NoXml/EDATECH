package ru.eda.tech.controller.api.entity.update;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;

import java.io.IOException;

class EntityUpdateRequestTest extends JsonTestContext {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        EntityUpdateRequest entityUpdateRequest = new EntityUpdateRequest(1L, "test");
        shouldDeserialize("EntityUpdateRequest.json", entityUpdateRequest);
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws Exception {
        EntityUpdateResponse entityUpdateResponse = new EntityUpdateResponse(1L, "test");
        shouldSerialize(entityUpdateResponse, "EntityUpdateResponse.json");
    }

}