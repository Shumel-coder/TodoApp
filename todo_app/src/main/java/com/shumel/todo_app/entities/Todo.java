package com.shumel.todo_app.entities;

import jakarta.persistence.*;



@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "task", nullable = false)
    private String task;

    @Column(name = "completed", nullable = false)
    private Boolean completed = false;

    public Todo() {
    }

    public Todo(String task, Boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}