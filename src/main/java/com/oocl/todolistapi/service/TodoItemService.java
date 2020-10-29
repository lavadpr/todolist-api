package com.oocl.todolistapi.service;

import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {
    private TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getAllEmployees() {
        return todoItemRepository.findAll();
    }

    public TodoItem create(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    public void deleteTodoItem(Integer id) {
        todoItemRepository.deleteById(id);
    }
}
