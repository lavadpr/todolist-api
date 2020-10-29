package com.oocl.todolistapi.service;

import com.oocl.todolistapi.exception.TodoItemException;
import com.oocl.todolistapi.model.TodoItem;
import com.oocl.todolistapi.repository.TodoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.oocl.todolistapi.exception.TodoItemException.TODO_NOT_FOUND;

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

    public TodoItem update(Integer id, TodoItem todoItem) {
        TodoItem retrievedTodoItem = retrieve(id);
        retrievedTodoItem.setDone(todoItem.getDone());
        return todoItemRepository.save(retrievedTodoItem);
    }

    public TodoItem retrieve(Integer id) {
        return todoItemRepository.findById(id)
                .orElseThrow(() -> new TodoItemException(TODO_NOT_FOUND));
    }
}
