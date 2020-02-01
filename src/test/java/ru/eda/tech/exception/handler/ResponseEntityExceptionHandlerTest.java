package ru.eda.tech.exception.handler;

import org.junit.jupiter.api.Test;
import ru.eda.tech.base.ResponseEntityExceptionHandlerTestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ResponseEntityExceptionHandlerTest extends ResponseEntityExceptionHandlerTestContext {

    @Test
    void handleConflict1EntityControllerReadIdNotANumber() {
        String responseContentExpected = copyResponseContentToStringFromResourceIfNotNullErrorCodeAndNotNullMessageExpected(handleConflict1ResponseContentExpected);

        String responseContent = getResponseContentWithExpectedStatus(
                get("/entity/qwe"),
                status().isInternalServerError()
        );

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void handleConflict2EntityControllerUpdateIdNotANumberInEntityUpdateRequest() {
        String requestContent = copyRequestOrResponseContentToStringFromResource(handleConflict2RequestContent);
        String responseContentExpected = copyResponseContentToStringFromResourceIfNotNullErrorCodeAndNotNullMessageExpected(handleConflict2ResponseContentExpected);

        String responseContent = getResponseContentWithExpectedStatus(
                put("/entity")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent),
                status().isInternalServerError()
        );

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }
}