package ru.eda.tech.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.StreamUtils;
import ru.eda.tech.service.entity.EntityService;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({EntityController.class, EntityService.class})
class EntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

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
    private Resource deleteById1ResponseContentExpected;

    @Test
    void create() throws Exception {

        String requestContent = null;
        String responseContentExpected = null;
        try (InputStream inputRequestContent = createRequestContent.getInputStream();
             InputStream inputResponseContentExpected = createResponseContentExpected.getInputStream()) {
            requestContent = StreamUtils.copyToString(inputRequestContent, StandardCharsets.UTF_8);
            responseContentExpected = StreamUtils.copyToString(inputResponseContentExpected, StandardCharsets.UTF_8);
        }

        MvcResult mvcResult = mockMvc
                .perform(post("/entity")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent))
                .andDo(print())
                .andExpect(status().isOk()) //Здесь 404, а не 200
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();

        responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void readAll() throws Exception {
        String responseContentExpected = null;
        try (InputStream inputResponseContentExpected = readAllResponseContentExpected.getInputStream()) {
            responseContentExpected = StreamUtils.copyToString(inputResponseContentExpected, StandardCharsets.UTF_8);
        }

        MvcResult mvcResult = mockMvc.perform(get("/entity"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();

        responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void read() throws Exception {
        String responseContentExpected = null;
        try (InputStream inputResponseContentExpected = readById1ResponseContentExpected.getInputStream()) {
            responseContentExpected = StreamUtils.copyToString(inputResponseContentExpected, StandardCharsets.UTF_8);
        }

        MvcResult mvcResult = mockMvc.perform(get("/entity/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();

        responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void update() throws Exception {
        String requestContent = null;
        String responseContentExpected = null;
        try (InputStream inputRequestContent = updateRequestContent.getInputStream();
             InputStream inputResponseContentExpected = updateResponseContentExpected.getInputStream()) {
            requestContent = StreamUtils.copyToString(inputRequestContent, StandardCharsets.UTF_8);
            responseContentExpected = StreamUtils.copyToString(inputResponseContentExpected, StandardCharsets.UTF_8);
        }
        MvcResult mvcResult = mockMvc
                .perform(put("/entity")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();

        responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }

    @Test
    void delete() throws Exception {
        String responseContentExpected = null;
        try (InputStream inputResponseContentExpected = deleteById1ResponseContentExpected.getInputStream()) {
            responseContentExpected = StreamUtils.copyToString(inputResponseContentExpected, StandardCharsets.UTF_8);
        }

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/entity/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();

        responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

        assertThat(responseContent).isEqualTo(responseContentExpected);
    }
}