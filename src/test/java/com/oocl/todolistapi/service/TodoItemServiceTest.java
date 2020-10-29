package com.oocl.todolistapi.service;

import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.repository.TodoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoItemServiceTest {
    private TodoItemRepository todoItemRepository;
    private TodoItemService todoItemService;

    @BeforeEach
    void setUp() {
        todoItemRepository = mock(TodoItemRepository.class);
        todoItemService = new TodoItemService(todoItemRepository);
    }

    @Test
    void should_return_all_when_getAll() {
        //given
        List<TodoItem> expected = asList(new TodoItem(), new TodoItem());
        //when
        when(todoItemRepository.findAll()).thenReturn(expected);
        List<TodoItem> actual = todoItemService.getAll();
        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_todos_when_create_given_task() {
        //given
        TodoItem todoItem = new TodoItem("RaactJs",false);
        //when
        when(todoItemRepository.save(todoItem)).thenReturn(todoItem);
        //then
        assertEquals(todoItemService.create(todoItem),todoItem);
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