package com.oocl.todolistapi.controller;

import com.oocl.todolistapi.dto.TodoItemRequest;
import com.oocl.todolistapi.dto.TodoItemResponse;
import com.oocl.todolistapi.mapper.TodoItemMapper;
import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.service.TodoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class TodoItemController {
    private final TodoItemService todoItemService;
    private final TodoItemMapper todoItemMapper;

    public TodoItemController(TodoItemService todoItemService, TodoItemMapper todoItemMapper) {
        this.todoItemService = todoItemService;
        this.todoItemMapper = todoItemMapper;
    }

    @GetMapping
    public List<TodoItemResponse> getAll() {
        List<TodoItem> todoItems = todoItemService.getAll();
        return todoItems.stream().map(todoItemMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TodoItemResponse getById(@PathVariable Integer id) {
        TodoItem  todoItem = todoItemService.retrieve(id);
        return todoItemMapper.toResponse(todoItem);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemResponse addTodoItem(@RequestBody TodoItemRequest todoItemRequest) {
        TodoItem todoItem =todoItemService.create(todoItemMapper.toEntity(todoItemRequest));
        return todoItemMapper.toResponse(todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable Integer id) {
        todoItemService.deleteTodoItem(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItemResponse updateTodoItem(@PathVariable Integer id,@RequestBody TodoItemRequest todoItemRequest) {
        TodoItem todoItem = todoItemService.update(id,todoItemMapper.toEntity(todoItemRequest));
        return todoItemMapper.toResponse(todoItem);
    }


}
