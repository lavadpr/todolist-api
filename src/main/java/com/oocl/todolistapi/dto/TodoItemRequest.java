package com.oocl.todolistapi.dto;

public class TodoItemRequest {
    String text;
    Boolean done;

    public TodoItemRequest(String text, Boolean done) {
        this.text = text;
        this.done = done;
    }

    public TodoItemRequest (){

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }
    public void setDone(Boolean done) {
        this.done = done;
    }

}
