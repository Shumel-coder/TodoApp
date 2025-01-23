package com.shumel.todo_app.repositories;

import com.shumel.todo_app.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Override
    public Optional<Todo> findById(Long aLong);
    Todo findByTask(String task);
    List<Todo> findByCompletedTrue();
    List<Todo> findByCompletedFalse();
    List<Todo> findAll();


}
