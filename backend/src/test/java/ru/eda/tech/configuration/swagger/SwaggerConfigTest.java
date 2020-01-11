package ru.eda.tech.configuration.swagger;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.eda.tech.service.entity.EntityServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@ContextConfiguration(classes = { EntityServiceImpl.class })
class SwaggerConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getSwaggerUIStatus() throws Exception {
        mockMvc.perform(get("/swagger-ui.html"))
                .andExpect(status().isOk());
    }

}
