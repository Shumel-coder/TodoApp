package com.shumel.todo_app.controllers;

import com.shumel.todo_app.entities.Todo;
import com.shumel.todo_app.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Todo>> getTodosByUser(@PathVariable Long userId) {
        System.out.println("Fetching todos for user: " + userId);
        List<Todo> todos = todoService.getTodosByUser(userId);
        System.out.println("Found todos: " + todos.size());
        return ResponseEntity.ok(todos);
    }

    @PostMapping("/")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        System.out.println("Received todo: " + todo.getTask());
        System.out.println("User ID: " + todo.getUser().getId());

        Todo savedTodo = todoService.addTodo(todo);
        System.out.println("Saved todo: " + savedTodo.getTask());
        return ResponseEntity.ok(savedTodo);
    }

    @GetMapping("/user/{userId}/completed")
    public ResponseEntity<List<Todo>> getAllCompleted(@PathVariable Long userId) {
        return ResponseEntity.ok(todoService.getCompletedTodosByUser(userId));
    }

    @GetMapping("/user/{userId}/incomplete")
    public ResponseEntity<List<Todo>> getAllIncomplete(@PathVariable Long userId) {
        return ResponseEntity.ok(todoService.getIncompleteTodosByUser(userId));
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
