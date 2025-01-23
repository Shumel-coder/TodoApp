package com.shumel.todo_app.controllers;

import com.shumel.todo_app.entities.Todo;
import com.shumel.todo_app.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getAllCompleted() {
        return ResponseEntity.ok(todoService.getAllCompleted());
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<Todo>> getAllIncomplete() {
        return ResponseEntity.ok(todoService.getAllIncomplete());
    }
    @PostMapping("/")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.addTodo(todo));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        todo.setId(id);
        return ResponseEntity.ok(todoService.updateTodo(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok(true);
    }
}
