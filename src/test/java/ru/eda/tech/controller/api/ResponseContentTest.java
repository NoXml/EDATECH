package ru.eda.tech.controller.api;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;

class ResponseContentTest extends JsonTestContext {

    @Test
    public void whenUseOfAndSerializeUsingJsonGetter_ThenCorrect() {
        ResponseContent<EntityCreateResponse> responseContent = ResponseContent
                .<EntityCreateResponse>status(Status.SUCCESS)
                .buildWith(new EntityCreateResponse(1L, "test"));
        shouldSerialize(responseContent, "ResponseSuccess.json");
    }

    @Test
    public void whenUseSuccessAndSerializeUsingJsonGetter_ThenCorrect() {
        ResponseContent<EntityCreateResponse> responseContent = ResponseContent
                .<EntityCreateResponse>success()
                .buildWith(new EntityCreateResponse(1L, "test"));
        shouldSerialize(responseContent, "ResponseSuccess.json");
    }

    @Test
    public void whenUseFailedAndSerializeUsingJsonGetter_ThenCorrect() {
        ResponseContent<EntityCreateResponse> responseContent = ResponseContent
                .<EntityCreateResponse>failed()
                .errorCode("507","Message 507")
                .build();
        shouldSerialize(responseContent, "ResponseFailed.json");
    }
}