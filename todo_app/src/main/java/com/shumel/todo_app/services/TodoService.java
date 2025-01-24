package com.shumel.todo_app.services;

import com.shumel.todo_app.entities.Todo;
import com.shumel.todo_app.entities.User;
import com.shumel.todo_app.repositories.TodoRepository;
import com.shumel.todo_app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    public Todo addTodo(Todo todo) {
        // Ensure user is loaded from database
        User user = userRepository.findById(todo.getUser().getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        todo.setUser(user);
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosByUser(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    public List<Todo> getCompletedTodosByUser(Long userId) {
        return todoRepository.findByUserIdAndCompletedTrue(userId);
    }

    public List<Todo> getIncompleteTodosByUser(Long userId) {
        return todoRepository.findByUserIdAndCompletedFalse(userId);
    }

    public Todo updateTodo(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId())
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        if (todo.getTask() != null) {
            existingTodo.setTask(todo.getTask());
        }
        existingTodo.setCompleted(todo.getCompleted());

        return todoRepository.save(existingTodo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
