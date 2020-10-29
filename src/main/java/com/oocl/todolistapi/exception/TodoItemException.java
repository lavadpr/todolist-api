package com.oocl.todolistapi.exception;

public class TodoItemException extends RuntimeException {
    public static final String TODO_NOT_FOUND = "Todo Not Found";
    public TodoItemException(String message) {
        super(message);
    }
}
