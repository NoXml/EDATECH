package ru.eda.tech.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.eda.tech.base.EntityControllerTestContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EntityControllerTest extends EntityControllerTestContext {

    @Test
    void create() {
        Assertions.assertDoesNotThrow(() -> {
            String requestContent = copyToStringFromResource(createRequestContent);
            String responseContentExpected = copyToStringFromResource(createResponseContentExpected);

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
        });
    }

    @Test
    void readAll() {
        Assertions.assertDoesNotThrow(() -> {
            String responseContentExpected = copyToStringFromResource(readAllResponseContentExpected);

            MvcResult mvcResult = mockMvc.perform(get("/entity"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
            String responseContent = mvcResult.getResponse().getContentAsString();

            responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

            assertThat(responseContent).isEqualTo(responseContentExpected);
        });
    }

    @Test
    void read() {
        Assertions.assertDoesNotThrow(() -> {
            String responseContentExpected = copyToStringFromResource(readById1ResponseContentExpected);

            MvcResult mvcResult = mockMvc.perform(get("/entity/1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
            String responseContent = mvcResult.getResponse().getContentAsString();

            responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

            assertThat(responseContent).isEqualTo(responseContentExpected);
        });
    }

    @Test
    void update() {
        Assertions.assertDoesNotThrow(() -> {
            String requestContent = copyToStringFromResource(updateRequestContent);
            String responseContentExpected = copyToStringFromResource(updateResponseContentExpected);

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
        });
    }

    @Test
    void delete() {
        Assertions.assertDoesNotThrow(() -> {
            String responseContentExpected = copyToStringFromResource(deleteById1ResponseContentExpected);

            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete("/entity/1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
            String responseContent = mvcResult.getResponse().getContentAsString();

            responseContentExpected = responseContentExpected.replaceAll("\\s++", "");

            assertThat(responseContent).isEqualTo(responseContentExpected);
        });
    }
}