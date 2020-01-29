package ru.eda.tech.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import ru.eda.tech.controller.EntityController;
import ru.eda.tech.service.entity.EntityService;

@WebMvcTest({EntityController.class, EntityService.class})
public abstract class EntityControllerTestContext extends WebMvcTestContext {

    @Value("classpath:/ru/eda/tech/controller/EntityControllerCreateRequestContent.json")
    protected Resource createRequestContent;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerCreateResponseContentExpected.json")
    protected Resource createResponseContentExpected;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerReadAllResponseContentExpected.json")
    protected Resource readAllResponseContentExpected;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerReadById1ResponseContentExpected.json")
    protected Resource readById1ResponseContentExpected;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerUpdateRequestContent.json")
    protected Resource updateRequestContent;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerUpdateResponseContentExpected.json")
    protected Resource updateResponseContentExpected;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerDeleteById1ResponseContentExpected.json")
    protected Resource deleteById1ResponseContentExpected;

}
