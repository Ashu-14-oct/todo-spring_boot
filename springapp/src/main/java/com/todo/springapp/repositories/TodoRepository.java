package com.todo.springapp.repositories;

import org.springframework.stereotype.Repository;
import com.todo.springapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{}
