
package com.shumel.todo_app.repositories;

import com.shumel.todo_app.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserId(Long userId);
    List<Todo> findByUserIdAndCompletedTrue(Long userId);
    List<Todo> findByUserIdAndCompletedFalse(Long userId);
}
