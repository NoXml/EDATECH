package ru.eda.tech.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public abstract class WebMvcTestContext {
    @Autowired
    protected MockMvc mockMvc;

    protected String getResponseContentStatusIsOk(RequestBuilder requestBuilder) {
        try {
            return mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Error while performing a request with: " + requestBuilder.toString(), e);
        }
    }

    protected String getResponseContentWithExpectedStatus(RequestBuilder requestBuilder, ResultMatcher statusMatcher) {
        try {
            return mockMvc.perform(requestBuilder)
                    .andDo(print())
                    .andExpect(statusMatcher)
                    .andReturn()
                    .getResponse()
                    .getContentAsString();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Error while performing a request with: " + requestBuilder.toString(), e);
        }
    }

    public String copyRequestOrResponseContentToStringFromResource(Resource resource) {
        String requestContent = copyToStringFromResource(resource);
        return deleteAllWhiteSpaces(requestContent);
    }

    public String copyResponseContentToStringFromResourceIfMessageExpected(Resource resource) {
        String responseContent = copyToStringFromResource(resource);
        return deleteAllWhiteSpacesExceptMessage(responseContent);
    }

    private String copyToStringFromResource(Resource resource) {
        String result = null;
        try {
            try (InputStream inputResourceContent = resource.getInputStream()) {
                result = StreamUtils.copyToString(inputResourceContent, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(
                    "Error while copying from: " + resource.getDescription(), e);
        }
        return result;
    }

    private String deleteAllWhiteSpaces(String requestContent) {
        return requestContent.replaceAll("\\s++", "");
    }

    private String deleteAllWhiteSpacesExceptMessage(String responseContent) {
        String template = "\"message\": ";
        int startIndexOfMessageContent = responseContent.indexOf(template) + template.length();
        int endIndexOfMessageContent = responseContent.lastIndexOf("\"");
        String messageContent = responseContent.substring(startIndexOfMessageContent, endIndexOfMessageContent);
        String responseContentWithoutMessageContentAndEndingAndWhiteSpaces = responseContent
                .substring(0, startIndexOfMessageContent)
                .replaceAll("\\s++", "");
        String endingWithoutWhiteSpaces = responseContent
                .substring(endIndexOfMessageContent)
                .replaceAll("\\s++", "");
        return responseContentWithoutMessageContentAndEndingAndWhiteSpaces.concat(messageContent).concat(endingWithoutWhiteSpaces);
    }
}
