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

    private RequestBuilder requestOf(MockHttpServletRequestBuilder requestBuilder, Resource resource) {
        return requestBuilder.characterEncoding(UTF_8.name())
                .contentType(APPLICATION_JSON)
                .content(getContentFromResource(resource));
    }

    private Stream<Arguments> dataForTestingRequestValidation() {
        return Stream.of(
                //[1]
                of(requestOf(post("/entities"), createNameIsNull),
                        failed400NameNotBlank),
                //[2]
                of(requestOf(post("/entities"), createNameIsEmpty),
                        failed400NameNotBlank),
                //[3]
                of(requestOf(post("/entities"), createNameIsOutOfBounds),
                        failed400NameSize),
                //[4]
                of(get("/entities/-1"),
                        failed400ReadIdPositive),
                //[5]
                of(requestOf(put("/entities"), updateIdIsNull),
                        failed400IdNotNull),
                //[6]
                of(requestOf(put("/entities"), updateIdIsNotPositive),
                        failed400IdPositive),
                //[7]
                of(requestOf(put("/entities"), updateNameIsNull),
                        failed400NameNotBlank),
                //[8]
                of(requestOf(put("/entities"), updateNameIsEmpty),
                        failed400NameNotBlank),
                //[9]
                of(requestOf(put("/entities"), updateNameIsOutOfBounds),
                        failed400NameSize),
                //[10]
                of(delete("/entities/-1"),
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