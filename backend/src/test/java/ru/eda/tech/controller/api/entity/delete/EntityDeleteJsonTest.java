package ru.eda.tech.controller.api.entity.delete;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;

import java.io.IOException;

public class EntityDeleteJsonTest extends JsonTestContext {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() throws IOException {
        EntityDeleteRequest entityDeleteRequest = new EntityDeleteRequest(1L);
        shouldDeserialize("EntityDeleteRequest.json", entityDeleteRequest);
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() throws Exception {
        EntityDeleteResponse entityDeleteResponse = new EntityDeleteResponse(1L, "test");
        shouldSerialize(entityDeleteResponse, "EntityDeleteResponse.json");
    }

}