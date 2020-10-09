package ru.eda.tech.controller.entity.dto.update;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;

class EntityUpdateJsonTest extends JsonTestContext {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() {
        EntityUpdateRequest entityUpdateRequest = new EntityUpdateRequest(1L, "test");
        shouldDeserialize("EntityUpdateRequest.json", entityUpdateRequest);
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() {
        EntityUpdateResponse entityUpdateResponse = new EntityUpdateResponse(1L, "test");
        shouldSerialize(entityUpdateResponse, "EntityUpdateResponse.json");
    }

}