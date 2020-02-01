package ru.eda.tech.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.eda.tech.base.IntegrationTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

class EntityControllerTest extends IntegrationTest {

    @Value("classpath:/ru/eda/tech/controller/EntityControllerCreateRequestContent.json")
    private Resource createRequestContent;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerCreateResponseContentExpected.json")
    private Resource createResponseContentExpected;

    @Value("classpath:/ru/eda/tech/controller/EntityControllerReadAllResponseContentExpected.json")
    private Resource readAllResponseContentExpected;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerReadById1ResponseContentExpected.json")
    private Resource readById1ResponseContentExpected;

    @Value("classpath:/ru/eda/tech/controller/EntityControllerUpdateRequestContent.json")
    private Resource updateRequestContent;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerUpdateResponseContentExpected.json")
    private Resource updateResponseContentExpected;

    @Value("classpath:/ru/eda/tech/controller/EntityControllerDeleteById1ResponseContentExpected.json")
    private Resource deleteResponseContentExpected;

    @Test
    void create() {
        String requestContent = copyToStringFromResource(createRequestContent);
        String responseContentExpected = copyToStringFromResource(createResponseContentExpected);

        String responseContent = getResponseContent(post("/entity")
                .contentType(APPLICATION_JSON)
                .content(requestContent));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void readAll() {
        String responseContentExpected = copyToStringFromResource(readAllResponseContentExpected);

        String responseContent = getResponseContent(get("/entity"));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void read() {
        String responseContentExpected = copyToStringFromResource(readById1ResponseContentExpected);

        String responseContent = getResponseContent(get("/entity/1"));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void update() {
        String requestContent = copyToStringFromResource(updateRequestContent);
        String responseContentExpected = copyToStringFromResource(updateResponseContentExpected);

        String responseContent = getResponseContent(put("/entity")
                .contentType(APPLICATION_JSON)
                .content(requestContent));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void delete() {
        String responseContentExpected = copyToStringFromResource(deleteResponseContentExpected);

        String responseContent = getResponseContent(MockMvcRequestBuilders.delete("/entity/1"));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }
}