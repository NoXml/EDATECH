package ru.eda.tech.controller.entity.dto.create;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;

public class EntityCreateJsonTest extends JsonTestContext {

    @Test
    public void whenDeserializingUsingJsonCreator_thenCorrect() {
        EntityCreateRequestDTO entityCreateRequest = new EntityCreateRequestDTO("test");
        shouldDeserialize("EntityCreateRequest.json", entityCreateRequest);
    }

    @Test
    void whenSerializingUsingJsonGetter_thenCorrect() {
        EntityCreateResponseDTO entityCreateResponse = new EntityCreateResponseDTO(1L, "test");
        shouldSerialize(entityCreateResponse, "EntityCreateResponse.json");
    }
}