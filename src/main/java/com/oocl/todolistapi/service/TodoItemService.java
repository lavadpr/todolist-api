package com.oocl.todolistapi.service;

import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {
    private TodoItemRepository todoItemRepository;

    public TodoItemService(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    public List<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public TodoItem create(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    public void deleteTodoItem(Integer id) {
        todoItemRepository.deleteById(id);
    }
    //TODO add exception
    public TodoItem update(Integer id, TodoItem todoItem) {
        TodoItem todoItem1 = todoItemRepository.findById(id).get();
        todoItem1.setDone(todoItem.getDone());
        return todoItemRepository.save(todoItem1);
    }

    public TodoItem retreive(Integer id) {
        return todoItemRepository.findById(id).get();
    }
}
