package com.oocl.todolistapi.controller;

import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.service.TodoItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoItemController {
    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping
    public List<TodoItem> getAll() {
        return todoItemService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public TodoItem getById(@PathVariable Integer id) {
        return todoItemService.retreive(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem addTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.create(todoItem);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoItem(@PathVariable Integer id) {
        todoItemService.deleteTodoItem(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoItem updateTodoItem(@PathVariable Integer id,@RequestBody TodoItem todoItem) {
        return todoItemService.update(id,todoItem);
    }


}
