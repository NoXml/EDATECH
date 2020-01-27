package ru.eda.tech.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.StreamUtils;
import ru.eda.tech.controller.EntityController;
import ru.eda.tech.service.entity.EntityService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({EntityController.class, EntityService.class})
public abstract class EntityControllerTestContext {
    @Autowired
    protected MockMvc mockMvc;

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

    protected String getResponseContent(RequestBuilder requestBuilder) {
        MvcResult mvcResult = null;
        String responseContent = null;
        try {
            mvcResult = mockMvc
                    .perform(requestBuilder)
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
            responseContent = mvcResult.getResponse().getContentAsString();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Error while performing a request with: " + requestBuilder.toString(), e);
        }
        return responseContent;
    }

    protected String copyToStringFromResource(Resource resource) {
        String result = null;
        try {
            try (InputStream inputResourceContent = resource.getInputStream()) {
                result = StreamUtils.copyToString(inputResourceContent, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Error while copying from: " + resource.getDescription(), e);
        }
        return result.replaceAll("\\s++", "");
    }
}
