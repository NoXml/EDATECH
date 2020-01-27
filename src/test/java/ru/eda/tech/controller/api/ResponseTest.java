package ru.eda.tech.controller.api;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;

class ResponseTest extends JsonTestContext {

    @Test
    public void whenUseOfAndSerializeUsingJsonGetter_ThenCorrect() {
        Response<EntityCreateResponse> response = Response
                .<EntityCreateResponse>status(ResponseStatus.SUCCESS)
                .buildWith(new EntityCreateResponse(1L, "test"));
        shouldSerialize(response, "ResponseSuccess.json");
    }

    @Test
    public void whenUseSuccessAndSerializeUsingJsonGetter_ThenCorrect() {
        Response<EntityCreateResponse> response = Response
                .<EntityCreateResponse>success()
                .buildWith(new EntityCreateResponse(1L, "test"));
        shouldSerialize(response, "ResponseSuccess.json");
    }

    @Test
    public void whenUseFailedAndSerializeUsingJsonGetter_ThenCorrect() {
        Response<EntityCreateResponse> response = Response
                .<EntityCreateResponse>failed()
                .errorCode("507","Message 507")
                .build();
        shouldSerialize(response, "ResponseFailed.json");
    }
}