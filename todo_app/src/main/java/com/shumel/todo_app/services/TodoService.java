package com.shumel.todo_app.services;

import com.shumel.todo_app.entities.Todo;
import com.shumel.todo_app.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getAllCompleted() {
        return todoRepository.findByCompletedTrue();
    }

    public List<Todo> getAllIncomplete() {
        return todoRepository.findByCompletedFalse();
    }

    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }
}
