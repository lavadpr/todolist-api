package com.oocl.todolistapi.integration;

import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.repository.TodoItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodoItemIntegrationTest {
    @Autowired
    private TodoItemRepository todoItemRepository;

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void tearDown() {
        todoItemRepository.deleteAll();
    }

    @Test
    void should_return_todo_when_get_all() throws Exception {
        TodoItem todoItem = new TodoItem("test", false);
        todoItemRepository.save(todoItem);

        //when
        //then
        mockMvc.perform(get("/todos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].text").value("test"))
                .andExpect(jsonPath("$[0].done").value(false));
    }

    @Test
    void create() {
    }

    @Test
    void deleteTodoItem() {
    }

    @Test
    void update() {
    }

    @Test
    void retreive() {
    }
}