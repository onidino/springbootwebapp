package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.service.TodoService;
import com.in28minutes.springboot.springbootwebapp.todo.Todo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping("list-todos")
  public String listAllTodos(ModelMap model) {
    List<Todo> todosResult = todoService.findByUsername("in28minutes");
    if (!todosResult.isEmpty()) {
      model.addAttribute("todos", todosResult);
    }
    return "listTodos";
  }
}
