package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.service.TodoService;
import com.in28minutes.springboot.springbootwebapp.todo.Todo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

  /**
   * Controller to list all the todos and the list-todos page.
   *
   * @param model model map
   * @return the list-todos page.
   */
  @RequestMapping(value = "list-todos")
  public String listAllTodos(ModelMap model) {
    List<Todo> todosResult = todoService.findByUsername("in28minutes");
    if (!todosResult.isEmpty()) {
      model.addAttribute("todos", todosResult);
    }
    return "JSP_ListTodos";
  }

  /**
   * Controller to show the add a new to-do page.
   *
   * @return the add to-do page.
   */
  @GetMapping(value = "add-todo")
  public String showNewTodoPage(ModelMap model) {
    Todo todo = new Todo(
        0,
        (String) model.get("name"),
        "",
        LocalDate.now().plusYears(1),
        false);

    model.put("todo", todo);
    return "JSP_Todo";
  }

  /**
   * Controller to create a new to-do and add it to the to-do list.
   *
   * @param model    the model map
   * @param todoBean the to-do bean way binding
   * @return redirects to the list-todos page.
   */
  @PostMapping(value = "add-todo")
  public String addNewTodoPage(ModelMap model, Todo todoBean) {
    todoService.addTodo(
        (String) model.get("name"),
        todoBean.getDescription(),
        LocalDate.now().plusYears(1),
        false);

    return "redirect:list-todos";
  }
}
