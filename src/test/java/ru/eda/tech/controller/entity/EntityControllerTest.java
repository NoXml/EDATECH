package ru.eda.tech.controller.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.eda.tech.base.IntegrationTest;
import ru.eda.tech.domain.entity.Entity;
import ru.eda.tech.domain.entity.Status;
import ru.eda.tech.repository.entity.EntityRepositoryImpl;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class EntityControllerTest extends IntegrationTest {

    @Value("classpath:/ru/eda/tech/controller/entity/entityController/CreateRequest.json")
    private Resource createRequest;
    @Value("classpath:/ru/eda/tech/controller/entity/entityController/CreateResponseExpected.json")
    private Resource createResponseExpected;

    @Value("classpath:/ru/eda/tech/controller/entity/entityController/ReadResponseExpected.json")
    private Resource readResponseExpected;
    @Value("classpath:/ru/eda/tech/controller/entity/entityController/ReadAllNotEmptyListResponseExpected.json")
    private Resource readAllNotEmptyListResponseExpected;
    @Value("classpath:/ru/eda/tech/controller/entity/entityController/ReadAllEmptyListResponseExpected.json")
    private Resource readAllEmptyListResponseExpected;

    @Value("classpath:/ru/eda/tech/controller/entity/entityController/UpdateRequest.json")
    private Resource updateRequest;
    @Value("classpath:/ru/eda/tech/controller/entity/entityController/UpdateResponseExpected.json")
    private Resource updateResponseExpected;

    @Value("classpath:/ru/eda/tech/controller/entity/entityController/DeleteResponseExpected.json")
    private Resource deleteResponseExpected;

    @Value("classpath:/ru/eda/tech/controller/entity/entityController/NotFoundWithId1ResponseExpected.json")
    private Resource notFoundWithId1ResponseExpected;

    @BeforeEach
    void clearStorage() {
        EntityRepositoryImpl.STORAGE.clear();
    }

    @Test
    void create() {
        String requestContent = getContentFromResource(createRequest);

        assertRestRequest(post("/entities")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent),
                createResponseExpected,
                status().isOk());
    }

    @Test
    void read() {
        putEntityToStorage(1L, "name");

        assertRestRequest(get("/entities/1"), readResponseExpected, status().isOk());
    }

    @Test
    void readNotFound() {
        assertRestRequest(get("/entities/1"), notFoundWithId1ResponseExpected, status().isOk());
    }

    @Test
    void readAllNotEmptyList() {
        putEntityToStorage(1L, "name");

        assertRestRequest(get("/entities"), readAllNotEmptyListResponseExpected, status().isOk());
    }

    @Test
    void readAllEmptyList() {
        assertRestRequest(get("/entities"), readAllEmptyListResponseExpected, status().isOk());
    }

    @Test
    void update() {
        putEntityToStorage(1L, "name");

        String requestContent = getContentFromResource(updateRequest);

        assertRestRequest(put("/entities")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent),
                updateResponseExpected,
                status().isOk());
    }

    @Test
    void updateNotFound() {
        String requestContent = getContentFromResource(updateRequest);

        assertRestRequest(put("/entities")
                        .contentType(APPLICATION_JSON)
                        .content(requestContent),
                notFoundWithId1ResponseExpected,
                status().isOk());
    }

    @Test
    void delete() {
        putEntityToStorage(1L, "name");

        assertRestRequest(MockMvcRequestBuilders.delete("/entities/1"), deleteResponseExpected, status().isOk());
    }

    @Test
    void deleteNotFound() {
        assertRestRequest(MockMvcRequestBuilders.delete("/entities/1"),
                notFoundWithId1ResponseExpected, status().isOk());
    }

    void putEntityToStorage(Long id, String name) {
        Entity entity = new Entity(id, name, Status.CREATED);
        EntityRepositoryImpl.STORAGE.put(entity.getId(), entity);
    }
}