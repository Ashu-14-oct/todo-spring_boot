package com.todo.springapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.springapp.dto.TodoDTO;
import com.todo.springapp.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @PostMapping("/add")
    public String createTodo(@RequestBody TodoDTO todoDTO){
        return todoService.createTodo(todoDTO);
    }
}
