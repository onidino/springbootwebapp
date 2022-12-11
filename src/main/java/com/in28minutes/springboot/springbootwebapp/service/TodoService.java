package com.in28minutes.springboot.springbootwebapp.service;

import com.in28minutes.springboot.springbootwebapp.todo.Todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Todo list service to obtain the data.
 */
@Service
public class TodoService {

  private static final List<Todo> todoList = new ArrayList<>();

  static {
    todoList.add(new Todo(
        1, "in28minutes", "Learn AWS",
        LocalDate.now().plusYears(1), false));
    todoList.add(new Todo(
        2, "in28minutes", "Learn DevOps",
        LocalDate.now().plusYears(2), false));
    todoList.add(new Todo(
        3, "in28minutes", "Learn Fullstack Dev",
        LocalDate.now().plusYears(3), false));
  }

  public List<Todo> findByUsername(String username) {
    return todoList;
  }

}
