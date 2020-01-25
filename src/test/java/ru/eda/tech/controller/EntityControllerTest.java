package ru.eda.tech.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.util.StreamUtils;
import ru.eda.tech.controller.api.Response;
import ru.eda.tech.controller.api.entity.create.EntityCreateRequest;
import ru.eda.tech.controller.api.entity.create.EntityCreateResponse;
import ru.eda.tech.service.entity.EntityService;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({EntityController.class, EntityService.class})
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

        // Тесты интеграционные. Тут мы не знаем про объекты. Оперируем только строками

        String msg = StreamUtils.copyToString(createRequest.getInputStream(), StandardCharsets.UTF_8);

        MvcResult mvcResult = mockMvc
                .perform(post("/entity")
                        .contentType(APPLICATION_JSON)
                        .content(msg))
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