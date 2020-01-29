package ru.eda.tech.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.eda.tech.base.EntityControllerTestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

class EntityControllerTest extends EntityControllerTestContext {

    @Test
    void create() {
        String requestContent = copyRequestOrResponseContentToStringFromResource(createRequestContent);
        String responseContentExpected = copyRequestOrResponseContentToStringFromResource(createResponseContentExpected);

        String responseContent = getResponseContentStatusIsOk(post("/entity")
                .contentType(APPLICATION_JSON)
                .content(requestContent));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void readAll() {
        String responseContentExpected = copyRequestOrResponseContentToStringFromResource(readAllResponseContentExpected);

        String responseContent = getResponseContentStatusIsOk(get("/entity"));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void read() {
        String responseContentExpected = copyRequestOrResponseContentToStringFromResource(readById1ResponseContentExpected);

        String responseContent = getResponseContentStatusIsOk(get("/entity/1"));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void update() {
        String requestContent = copyRequestOrResponseContentToStringFromResource(updateRequestContent);
        String responseContentExpected = copyRequestOrResponseContentToStringFromResource(updateResponseContentExpected);

        String responseContent = getResponseContentStatusIsOk(put("/entity")
                .contentType(APPLICATION_JSON)
                .content(requestContent));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void delete() {
        String responseContentExpected = copyRequestOrResponseContentToStringFromResource(deleteById1ResponseContentExpected);

        String responseContent = getResponseContentStatusIsOk(MockMvcRequestBuilders.delete("/entity/1"));

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }
}