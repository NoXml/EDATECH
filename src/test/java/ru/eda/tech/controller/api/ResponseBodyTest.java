package ru.eda.tech.controller.api;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;

class ResponseBodyTest extends JsonTestContext {

    @Test
    public void whenUseOfAndSerializeUsingJsonGetter_ThenCorrect() {
        ResponseBody<EntityCreateResponse> responseBody = ResponseBody
                .<EntityCreateResponse>status(Status.SUCCESS)
                .buildWith(new EntityCreateResponse(1L, "test"));
        shouldSerialize(responseBody, "ResponseSuccess.json");
    }

    @Test
    public void whenUseSuccessAndSerializeUsingJsonGetter_ThenCorrect() {
        ResponseBody<EntityCreateResponse> responseBody = ResponseBody
                .<EntityCreateResponse>success()
                .buildWith(new EntityCreateResponse(1L, "test"));
        shouldSerialize(responseBody, "ResponseSuccess.json");
    }

    @Test
    public void whenUseFailedAndSerializeUsingJsonGetter_ThenCorrect() {
        ResponseBody<EntityCreateResponse> responseBody = ResponseBody
                .<EntityCreateResponse>failed()
                .errorCode("507","Message 507")
                .build();
        shouldSerialize(responseBody, "ResponseFailed.json");
    }
}