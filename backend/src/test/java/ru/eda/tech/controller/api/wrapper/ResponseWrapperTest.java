package ru.eda.tech.controller.api.wrapper;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;

class ResponseWrapperTest extends JsonTestContext {

    @Test
    public void whenSerializeUsingJsonGetter_ThenCorrect() {
        ResponseWrapper<EntityCreateResponse> responseWrapper =
                new ResponseWrapper.Builder<>(
                        ResponseWrapperStatus.SUCCESS, new EntityCreateResponse(1L, "test"))
                        .build();
        shouldSerialize(responseWrapper, "ResponseWrapper.json");
    }
}