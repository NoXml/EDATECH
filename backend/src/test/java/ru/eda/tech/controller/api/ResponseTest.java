package ru.eda.tech.controller.api;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.JsonTestContext;
import ru.eda.tech.controller.api.Response;
import ru.eda.tech.controller.api.ResponseStatus;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;

class ResponseTest extends JsonTestContext {

    @Test
    public void whenUseOfAndSerializeUsingJsonGetter_ThenCorrect() {
        Response<EntityCreateResponse> response = Response
                        .of(new EntityCreateResponse(1L, "test"))
                        .status(ResponseStatus.SUCCESS)
                        .build();
        shouldSerialize(response, "ResponseSuccess.json");
    }

    @Test
    public void whenUseSuccessAndSerializeUsingJsonGetter_ThenCorrect() {
        Response<EntityCreateResponse> response = Response
                .success(new EntityCreateResponse(1L, "test"))
                .build();
        shouldSerialize(response, "ResponseSuccess.json");
    }

    @Test
    public void whenUseFailedAndSerializeUsingJsonGetter_ThenCorrect() {
        Response<EntityCreateResponse> response = Response
                .failed(new EntityCreateResponse(1L, "test"))
                .errorCode("507")
                .build();
        shouldSerialize(response, "ResponseFailed.json");
    }
}