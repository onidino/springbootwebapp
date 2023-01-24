package com.in28minutes.springboot.springbootwebapp.service;

import com.in28minutes.springboot.springbootwebapp.todo.Todo;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * To-do list service to obtain the data.
 */
@Service
public class TodoService {

  private static final List<Todo> todoList = new ArrayList<>();

  private static int todosCount = 0;

  static {
    todoList.add(new Todo(
        ++todosCount, "in28minutes", "Learn AWS",
        LocalDate.now().plusYears(1), false));
    todoList.add(new Todo(
        ++todosCount, "in28minutes", "Learn DevOps",
        LocalDate.now().plusYears(2), false));
    todoList.add(new Todo(
        ++todosCount, "in28minutes", "Learn Fullstack Dev",
        LocalDate.now().plusYears(3), false));
  }

  /**
   * Returns to-do count according to the username.
   *
   * @param username the username
   * @return the list of to-dos
   */
  public List<Todo> findByUsername(String username) {
    return todoList.stream()
        .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
        .toList();
  }

  /**
   * Method to add new todos to the list.
   *
   * @param username    the username
   * @param description the description of the to-do
   * @param targetDate  the target to complete the to-do
   * @param isDone      true/false
   */
  public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {
    todoList.add(new Todo(
        ++todosCount, username, description, targetDate, isDone));
  }

  /**
   * Method to delete todos from the list.
   *
   * @param id the id
   */
  public void deleteTodoById(int id) {
    todoList.removeIf(todo -> todo.getId() == id);
  }

  /**
   * Method to obtain the to-do by the id.
   *
   * @param id of the to-do to find
   * @return the to-do found
   */
  public Todo findById(int id) {
    return todoList.stream()
        .filter(todoId -> todoId.getId() == id)
        .findFirst()
        .orElse(null);
  }

  /**
   * Method to update the to-do.
   *
   * @param todo the to-do to update
   */
  public void updateTodo(@Valid Todo todo) {
    deleteTodoById(todo.getId());
    todoList.add(todo);
  }
}
