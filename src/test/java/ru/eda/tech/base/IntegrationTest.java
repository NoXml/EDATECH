package ru.eda.tech.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.StreamUtils;
import ru.eda.tech.controller.EntityController;
import ru.eda.tech.service.entity.EntityService;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({EntityController.class, EntityService.class})
public abstract class IntegrationTest {

    private static final Pattern WHITESPACES = Pattern.compile("\\s++");

    @Autowired
    private MockMvc mockMvc;

    protected String getResponseContent(RequestBuilder requestBuilder) {
        try {
            return mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Error while performing a request with: %s", requestBuilder), e);
        }
    }

    protected static String copyToStringFromResource(Resource resource) {
        try (InputStream inputResourceContent = resource.getInputStream()) {
            return WHITESPACES.matcher(StreamUtils.copyToString(inputResourceContent, StandardCharsets.UTF_8))
                    .replaceAll("");
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Error while copying from: " + resource.getDescription(), e);
        }
    }
}
