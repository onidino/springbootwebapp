package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.service.TodoService;
import com.in28minutes.springboot.springbootwebapp.todo.Todo;
import io.micrometer.common.util.StringUtils;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * TodoController to manage the to-do list.
 */
@Controller
@SessionAttributes("name")
public class TodoController {

  private final TodoService todoService;

  @Autowired
  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @RequestMapping(value = "list-todos")
  public String listAllTodos(ModelMap model) {
    List<Todo> todosResult = todoService.findByUsername("in28minutes");
    if (!todosResult.isEmpty()) {
      model.addAttribute("todos", todosResult);
    }
    return "JSP_ListTodos";
  }

  @GetMapping(value = "add-todo")
  public String showNewTodoPage() {
    return "JSP_AddTodo";
  }

  @PostMapping(value = "add-todo")
  public String addNewTodoPage(@RequestParam String description, ModelMap model) {
    if (!StringUtils.isEmpty(description)) {
      todoService.addTodo(
          model.get("name").toString(), description, LocalDate.now().plusYears(1), false);
    }
    return "redirect:list-todos";
  }
}
