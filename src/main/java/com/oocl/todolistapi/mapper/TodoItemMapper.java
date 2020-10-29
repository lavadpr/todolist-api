package com.oocl.todolistapi.mapper;

import com.oocl.todolistapi.dto.TodoItemRequest;
import com.oocl.todolistapi.dto.TodoItemResponse;
import com.oocl.todolistapi.model.TodoItem;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TodoItemMapper {
    public TodoItemResponse toResponse(TodoItem todoItem){
        TodoItemResponse todoItemResponse = new TodoItemResponse();
        BeanUtils.copyProperties(todoItem, todoItemResponse);
        return todoItemResponse;
    }

    public TodoItem toEntity(TodoItemRequest todoItemRequest){
        TodoItem todoItem = new TodoItem();
        BeanUtils.copyProperties(todoItemRequest, todoItem);
        return todoItem;
    }
}
