import React, { useEffect, useState } from "react";
import axios from "axios";
import "./App.css";

// Define Todo type
interface Todo {
  id: number;
  task: string;
  completed: boolean;
}

const App: React.FC = () => {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [task, setTask] = useState<string>("");
  const [searchFilter, setSearchFilter] = useState<string>("all");

  const API_BASE = "http://localhost:8080/api/todos";

  // Fetch Todos
  const fetchTodos = async () => {
    try {
      const response = await axios.get<Todo[]>(
        searchFilter === "completed"
          ? `${API_BASE}/completed`
          : searchFilter === "incomplete"
          ? `${API_BASE}/incomplete`
          : `${API_BASE}/`
      );
      setTodos(response.data);
    } catch (error) {
      console.error("Error fetching todos", error);
    }
  };

  useEffect(() => {
    fetchTodos();
  }, [searchFilter]);

  const addTodo = async () => {
    if (!task.trim()) {
      alert("Task is required");
      return;
    }

    try {
      const response = await axios.post<Todo>(`${API_BASE}/`, {
        task: task.trim(),
        completed: false,
      });

      // Update the state with the new Todo
      setTodos((prev) => [...prev, response.data]);

      // Clear the input field
      setTask("");
    } catch (error) {
      console.error("Error adding todo:", error);
      alert("Failed to add task. Please try again.");
    }
  };

  // Update Todo
  const updateTodo = async (id: number, updatedTodo: Partial<Todo>) => {
    try {
      const response = await axios.put<Todo>(`${API_BASE}/${id}`, {
        ...updatedTodo,
        id,
      });
      setTodos((prev) =>
        prev.map((todo) => (todo.id === id ? response.data : todo))
      );
    } catch (error) {
      console.error("Error updating todo", error);
    }
  };

  // Delete Todo
  const deleteTodo = async (id: number) => {
    try {
      await axios.delete(`${API_BASE}/${id}`);
      setTodos((prev) => prev.filter((todo) => todo.id !== id));
    } catch (error) {
      console.error("Error deleting todo", error);
    }
  };

  return (
    <div className="app-container">
      <h1>Todo App</h1>

      {/* Add Todo Form */}
      <div className="add-todo-container">
        <input
          type="text"
          placeholder="Task"
          value={task}
          onChange={(e) => setTask(e.target.value)}
        />
        <button onClick={addTodo}>Add</button>
      </div>

      {/* Filter Todos */}
      <select
        value={searchFilter}
        onChange={(e) => setSearchFilter(e.target.value)}
      >
        <option value="all">All</option>
        <option value="completed">Completed</option>
        <option value="incomplete">Incomplete</option>
      </select>

      {/* Todo List */}
      <div>
        {todos.map((todo) => (
          <div
            key={todo.id}
            className={`todo-item ${todo.completed ? "completed" : ""}`}
          >
            <h3
              className={`todo-item-text ${todo.completed ? "completed" : ""}`}
            >
              {todo.task}
            </h3>
            <div className="todo-buttons">
              <button
                className={`complete-btn ${todo.completed ? "completed" : ""}`}
                onClick={() =>
                  updateTodo(todo.id, { completed: !todo.completed })
                }
              >
                {todo.completed ? "Mark Incomplete" : "Mark Complete"}
              </button>
              <button
                className="delete-btn"
                onClick={() => deleteTodo(todo.id)}
              >
                Delete
              </button>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default App;
