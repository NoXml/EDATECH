package ru.eda.tech.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.ResolvableType;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import ru.eda.tech.controller.api.Response;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.service.entity.EntityService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@WebMvcTest(EntityController.class)
@ContextConfiguration(classes = {EntityService.class})
class EntityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("classpath:/ru/eda/tech/controller/EntityControllerCreateRequest.json")
    private Resource createRequest;
    @Value("classpath:/ru/eda/tech/controller/EntityControllerCreateResponse.json")
    private Resource createResponseExpected;

    @Test
    void create() throws Exception {
        EntityCreateRequest requestObject = objectMapper.readerFor(EntityCreateRequest.class)
                .readValue(createRequest.getFile());
        String requestString = objectMapper.writeValueAsString(requestObject);

        Response<EntityCreateResponse> responseExpected = objectMapper
                .readerFor(new TypeReference<Response<EntityCreateResponse>>() {
                })
                .readValue(createResponseExpected.getFile());

        MvcResult mvcResult = mockMvc
                .perform(post("/entity/")
                        .contentType(APPLICATION_JSON)
                        .content(requestString))
                .andDo(print())
                .andExpect(status().isOk()) //Здесь 404, а не 200
                .andReturn();
        String responseAsString = mvcResult.getResponse().getContentAsString();
        Response<EntityCreateResponse> response =
                objectMapper.readValue(responseAsString, new TypeReference<Response<EntityCreateResponse>>() {
                });

        assertThat(response).isEqualToComparingFieldByField(responseExpected);
    }

    @Test
    void readAll() {
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}