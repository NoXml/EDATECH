package ru.eda.tech.controller;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ru.eda.tech.base.IntegrationTest;

import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.params.provider.Arguments.of;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EntityControllerValidationTest extends IntegrationTest {

    @Value("classpath:/ru/eda/tech/controller/validation/EntityCreateRequestWhichNameIsNull.json")
    private Resource createRequestNameIsNull;

    @Value("classpath:/ru/eda/tech/controller/validation/EntityCreateRequestWhichNameIsEmpty.json")
    private Resource createRequestNameIsEmpty;

    @Value("classpath:/ru/eda/tech/controller/validation/EntityCreateRequestWhichNameIsOutOfBounds.json")
    private Resource createRequestNameIsOutOfBounds;

    @Value("classpath:/ru/eda/tech/controller/validation/EntityUpdateRequestWhichIdIsNull.json")
    private Resource updateRequestIdIsNull;

    @Value("classpath:/ru/eda/tech/controller/validation/EntityUpdateRequestWhichIdIsNotPositive.json")
    private Resource updateRequestIdIsNotPositive;

    @Value("classpath:/ru/eda/tech/controller/validation/EntityUpdateRequestWhichNameIsNull.json")
    private Resource updateRequestNameIsNull;

    @Value("classpath:/ru/eda/tech/controller/validation/EntityUpdateRequestWhichNameIsEmpty.json")
    private Resource updateRequestNameIsEmpty;

    @Value("classpath:/ru/eda/tech/controller/validation/EntityUpdateRequestWhichNameIsOutOfBounds.json")
    private Resource updateRequestNameIsOutOfBounds;

    @Value("classpath:/ru/eda/tech/controller/validation/ResponseContentFailedWithTechnicalError.json")
    private Resource responseContentFailedWithValidationFailure;

    private BiFunction<MockHttpServletRequestBuilder, Resource, RequestBuilder> buildRequest = (requestBuilder, resource) ->
            requestBuilder.characterEncoding(UTF_8.name())
                    .contentType(APPLICATION_JSON)
                    .content(getContentFromResource(resource));

    private Stream<Arguments> dataForTestingRequestValidation() {
        return Stream.of(
                of(buildRequest.apply(post("/entity"), createRequestNameIsNull)),
                of(buildRequest.apply(post("/entity"), createRequestNameIsEmpty)),
                of(buildRequest.apply(post("/entity"), createRequestNameIsOutOfBounds)),
                of(get("/entity/-1")),
                of(buildRequest.apply(put("/entity"), updateRequestIdIsNull)),
                of(buildRequest.apply(put("/entity"), updateRequestIdIsNotPositive)),
                of(buildRequest.apply(put("/entity"), updateRequestNameIsNull)),
                of(buildRequest.apply(put("/entity"), updateRequestNameIsEmpty)),
                of(buildRequest.apply(put("/entity"), updateRequestNameIsOutOfBounds)),
                of(delete("/entity/-1"))
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTestingRequestValidation")
    public void assertThatResponseWithHttpStatusCode400AndBodyStatusFailed(RequestBuilder requestBuilder) {
        assertRestRequest(requestBuilder, responseContentFailedWithValidationFailure, status().isBadRequest());
    }
}