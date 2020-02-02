package ru.eda.tech.configuration.handler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import ru.eda.tech.base.IntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ControllerExceptionHandlerTest extends IntegrationTest {

    @Value("classpath:/ru/eda/tech/configuration/handler/failedWithException.json")
    private Resource failedWithException;

    @Test
    void handleException() {
        assertRestRequest(get("/entity/qwe"), failedWithException, status().isInternalServerError());
    }
}