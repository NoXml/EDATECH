package ru.eda.tech.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.eda.tech.base.IntegrationTest;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.domain.entity.Status;
import ru.eda.tech.repository.entity.EntityRepository;
import ru.eda.tech.repository.entity.EntityRepositoryImpl;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EntityControllerTest extends IntegrationTest {

    @Value("classpath:/ru/eda/tech/controller/CreateRequest.json")
    private Resource createRequest;
    @Value("classpath:/ru/eda/tech/controller/CreateResponseExpected.json")
    private Resource createResponseExpected;

    @Value("classpath:/ru/eda/tech/controller/ReadAllResponseExpected.json")
    private Resource readAllResponseExpected;
    @Value("classpath:/ru/eda/tech/controller/ReadResponseExpected.json")
    private Resource readResponseExpected;

    @Value("classpath:/ru/eda/tech/controller/UpdateRequest.json")
    private Resource updateRequest;
    @Value("classpath:/ru/eda/tech/controller/UpdateResponseExpected.json")
    private Resource updateResponseExpected;

    @Value("classpath:/ru/eda/tech/controller/DeleteResponseExpected.json")
    private Resource deleteResponseExpected;

    @BeforeEach
    void clearStorage() {
        EntityRepositoryImpl.STORAGE.clear();
    }

    @Test
    void create() {
        String requestContent = getContentFromResource(createRequest);

        assertRestRequest(post("/entity")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent),
                createResponseExpected,
                status().isOk());
    }

    @Test
    void readAll() {
        assertRestRequest(get("/entity"), readAllResponseExpected, status().isOk());
    }

    @Test
    void read() {
        putEntityToSTORAGE(1L, "name");
        
        assertRestRequest(get("/entity/1"), readResponseExpected, status().isOk());
    }

    @Test
    void update() {
        putEntityToSTORAGE(1L, "name");

        String requestContent = getContentFromResource(updateRequest);

        assertRestRequest(put("/entity")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent),
                updateResponseExpected,
                status().isOk());
    }

    @Test
    void delete() {
        putEntityToSTORAGE(1L, "name");

        assertRestRequest(MockMvcRequestBuilders.delete("/entity/1"), deleteResponseExpected, status().isOk());
    }

    void putEntityToSTORAGE(Long id, String name) {
        Entity entity = new Entity(id, name, Status.CREATED);
        EntityRepositoryImpl.STORAGE.put(entity.getId().toString(), entity);
    }
}