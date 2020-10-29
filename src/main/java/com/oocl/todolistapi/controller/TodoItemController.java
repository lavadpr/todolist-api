package com.oocl.todolistapi.controller;

import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.service.TodoItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class TodoItemController {
    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public List<TodoItem> getAll() {
        return todoItemService.getAllEmployees().stream()
                .collect(Collectors.toList());
    }

}
