package ru.eda.tech.controller.api;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.eda.tech.base.JsonTestContext;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.of;

class ResponseTest extends JsonTestContext {

    private static Stream<Arguments> serializeData() {
        return Stream.of(
                of(Response.status(ResponseStatus.SUCCESS)
                        .build(new EntityCreateResponse(1L, "test")), "ResponseSuccess.json"),
                of(Response.success(new EntityCreateResponse(1L, "test")), "ResponseSuccess.json"),
                of(Response.success(), "EmptyResponseSuccess.json"),
                of(Response.failed(Error.of("507", "Message 507")), "ResponseFailed.json"),
                of(Response.failed(), "EmptyResponseFailed.json")
        );
    }

    @ParameterizedTest
    @MethodSource("serializeData")
    public void shouldSerializeObjectToJson(Object srcObject, String expectedJsonFilename) {
        shouldSerialize(srcObject, expectedJsonFilename);
    }
}