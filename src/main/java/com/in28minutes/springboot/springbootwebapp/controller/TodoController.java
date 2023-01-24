package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.security.SecurityUtils;
import com.in28minutes.springboot.springbootwebapp.service.TodoService;
import com.in28minutes.springboot.springbootwebapp.todo.Todo;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

  private static final String JSP_TODO = "JSP_Todo";
  private static final String JSP_LIST_TODOS = "JSP_ListTodos";
  private static final String REDIRECT_LIST_TODOS = "redirect:list-todos";
  private static final LocalDate DEFAULT_TARGET_DATE = LocalDate.now().plusYears(1);

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
    List<Todo> todosResult = todoService.findByUsername(SecurityUtils.getLoggedInUser());
    if (!todosResult.isEmpty()) {
      model.addAttribute("todos", todosResult);
    }
    return JSP_LIST_TODOS;
  }

  /**
   * Controller to show the add a new to-do page.
   *
   * @return the add to-do page.
   */
  @GetMapping(value = "add-todo")
  public String showNewTodoPage(ModelMap model) {
    Todo todo = new Todo(
        0, SecurityUtils.getLoggedInUser(), "", DEFAULT_TARGET_DATE, false);

    model.put("todo", todo);
    return JSP_TODO;
  }

  /**
   * Controller to create a new to-do and add it to the to-do list.
   *
   * @param todo the to-do bean way binding
   * @return redirects to the list-todos page.
   */
  @PostMapping(value = "add-todo")
  public String addNewTodoPage(@Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return JSP_TODO;
    }
    todoService.addTodo(
        SecurityUtils.getLoggedInUser(), todo.getDescription(), todo.getTargetDate(), false);

    return REDIRECT_LIST_TODOS;
  }

  /**
   * Controller to delete a to-do from the list.
   *
   * @return redirects to the list-todos page.
   */
  @RequestMapping(value = "delete-todo")
  public String deleteTodo(@RequestParam("id") int id) {
    todoService.deleteTodoById(id);

    return REDIRECT_LIST_TODOS;
  }

  /**
   * Controller to update a to-do from the list.
   *
   * @return redirects to the list-todos page.
   */
  @GetMapping(value = "update-todo")
  public String showUpdateTodoPage(@RequestParam("id") int id, ModelMap model) {
    Todo todo = todoService.findById(id);
    model.addAttribute("todo", todo);

    return JSP_TODO;
  }

  /**
   * Controller to update a to-do from the list.
   *
   * @return redirects to the list-todos page.
   */
  @PostMapping(value = "update-todo")
  public String updateTodo(@Valid Todo todo, BindingResult result) {
    if (result.hasErrors()) {
      return JSP_TODO;
    }
    todo.setUsername(SecurityUtils.getLoggedInUser());
    todoService.updateTodo(todo);

    return REDIRECT_LIST_TODOS;
  }

}
