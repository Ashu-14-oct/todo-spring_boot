package com.todo.springapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.springapp.dto.TodoDTO;
import com.todo.springapp.entity.Todo;
import com.todo.springapp.repositories.TodoRepository;

@Service
public class TodoService {
    
    @Autowired
    private TodoRepository todoRepository;

    public String createTodo(TodoDTO todoDTO){
        Todo todo = new Todo(todoDTO.getTitle(), todoDTO.getDescription());
        todoRepository.save(todo);

        return "Todo created successfully with ID: " + todo.getId();
    }
}
