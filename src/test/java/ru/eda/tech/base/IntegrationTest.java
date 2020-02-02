package ru.eda.tech.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.StreamUtils;
import ru.eda.tech.controller.EntityController;
import ru.eda.tech.controller.InfoController;
import ru.eda.tech.service.entity.EntityServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest({EntityController.class, InfoController.class, EntityServiceImpl.class})
public abstract class IntegrationTest {

    @Autowired
    protected MockMvc mockMvc;

    protected void assertRestRequest(RequestBuilder requestBuilder,
                                     Resource body,
                                     ResultMatcher... matchers) {
        try {
            mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpect(ResultMatcher.matchAll(matchers))
                    .andExpect(content().json(getContentFromResource(body), true));
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Error while performing a request with: " + requestBuilder, e);
        }
    }

    protected static String getContentFromResource(Resource resource) {
        try (InputStream inputResourceContent = resource.getInputStream()) {
            return StreamUtils.copyToString(inputResourceContent, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Error while copying from: " + resource.getDescription(), e);
        }
    }
}
