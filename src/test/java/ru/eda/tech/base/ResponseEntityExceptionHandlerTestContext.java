package ru.eda.tech.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import ru.eda.tech.controller.EntityController;
import ru.eda.tech.exception.handler.ResponseEntityExceptionHandler;
import ru.eda.tech.service.entity.EntityService;

@WebMvcTest({ResponseEntityExceptionHandler.class, EntityController.class, EntityService.class})
public abstract class ResponseEntityExceptionHandlerTestContext extends WebMvcTestContext {
    @Value("classpath:/ru/eda/tech/exception/handler" +
            "/ResponseEntityExceptionHandlerHandleConflict1ResponseContentExpected.json")
    protected Resource handleConflict1ResponseContentExpected;
    @Value("classpath:/ru/eda/tech/exception/handler" +
            "/ResponseEntityExceptionHandlerHandleConflict2RequestContent.json")
    protected Resource handleConflict2RequestContent;
    @Value("classpath:/ru/eda/tech/exception/handler" +
            "/ResponseEntityExceptionHandlerHandleConflict2ResponseContentExpected.json")
    protected Resource handleConflict2ResponseContentExpected;

}
