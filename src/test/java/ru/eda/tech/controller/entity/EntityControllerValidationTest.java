package ru.eda.tech.controller.entity;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import ru.eda.tech.base.IntegrationTest;

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

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityCreateRequestNameIsNull.json")
    private Resource createNameIsNull;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityCreateRequestNameIsEmpty.json")
    private Resource createNameIsEmpty;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityCreateRequestNameIsOutOfBounds.json")
    private Resource createNameIsOutOfBounds;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityUpdateRequestIdIsNull.json")
    private Resource updateIdIsNull;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityUpdateRequestIdIsNotPositive.json")
    private Resource updateIdIsNotPositive;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityUpdateRequestNameIsNull.json")
    private Resource updateNameIsNull;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityUpdateRequestNameIsEmpty.json")
    private Resource updateNameIsEmpty;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/requests/EntityUpdateRequestNameIsOutOfBounds.json")
    private Resource updateNameIsOutOfBounds;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/responses/ResponseContentFailed400NameNotBlank.json")
    private Resource failed400NameNotBlank;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/responses/ResponseContentFailed400NameSize.json")
    private Resource failed400NameSize;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/responses/ResponseContentFailed400IdNotNull.json")
    private Resource failed400IdNotNull;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/responses/ResponseContentFailed400IdPositive.json")
    private Resource failed400IdPositive;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/responses/ResponseContentFailed400ReadIdPositive.json")
    private Resource failed400ReadIdPositive;

    @Value("classpath:/ru/eda/tech/controller/entity/entityControllerValidation/responses/ResponseContentFailed400DeleteIdPositive.json")
    private Resource failed400DeleteIdPositive;

    private RequestBuilder requestOf(MockHttpServletRequestBuilder requestBuilder, Resource resource){
        return requestBuilder.characterEncoding(UTF_8.name())
                .contentType(APPLICATION_JSON)
                .content(getContentFromResource(resource));
    }

    private Stream<Arguments> dataForTestingRequestValidation() {
        return Stream.of(
                of(requestOf(post("/entity"), createNameIsNull),
                        failed400NameNotBlank),
                of(requestOf(post("/entity"), createNameIsEmpty),
                        failed400NameNotBlank),
                of(requestOf(post("/entity"), createNameIsOutOfBounds),
                        failed400NameSize),
                of(get("/entity/-1"),
                        failed400ReadIdPositive),
                of(requestOf(put("/entity"), updateIdIsNull),
                        failed400IdNotNull),
                of(requestOf(put("/entity"), updateIdIsNotPositive),
                        failed400IdPositive),
                of(requestOf(put("/entity"), updateNameIsNull),
                        failed400NameNotBlank),
                of(requestOf(put("/entity"), updateNameIsEmpty),
                        failed400NameNotBlank),
                of(requestOf(put("/entity"), updateNameIsOutOfBounds),
                        failed400NameSize),
                of(delete("/entity/-1"),
                        failed400DeleteIdPositive)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForTestingRequestValidation")
    public void assertBadRequestWithFailedContent(RequestBuilder requestBuilder,
                                                  Resource contentFailed) {
        assertRestRequest(requestBuilder, contentFailed, status().isBadRequest());
    }
}