package com.todo.springapp.dto;

public class TodoDTO {
    private String title;
    private String description;

    public TodoDTO(){}

    public TodoDTO(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
