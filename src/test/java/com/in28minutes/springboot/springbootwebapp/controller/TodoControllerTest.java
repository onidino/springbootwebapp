package com.in28minutes.springboot.springbootwebapp.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.in28minutes.springboot.springbootwebapp.entities.Todo;
import com.in28minutes.springboot.springbootwebapp.repository.TodoRepository;
import com.in28minutes.springboot.springbootwebapp.security.SecurityUtils;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

class TodoControllerTest {

  @Mock
  private TodoRepository todoRepository;

  @InjectMocks
  private TodoController todoController;

  private final MockedStatic<SecurityUtils> securityUtilsMocked = mockStatic(SecurityUtils.class);

  private AutoCloseable autoCloseable;

  private final Todo todoTest =
      new Todo(1, "username", "description", LocalDate.now(), false);

  @BeforeEach
  void before() {
    this.autoCloseable = MockitoAnnotations.openMocks(this);
    this.securityUtilsMocked.when(SecurityUtils::getLoggedInUser).thenReturn("test");
  }

  @AfterEach
  void after() throws Exception {
    this.autoCloseable.close();
    this.securityUtilsMocked.close();
  }

  @Test
  void test_listAllTodos_thenOk() {
    // when
    when(todoRepository.findByUsername(any()))
        .thenReturn(List.of(todoTest));

    String result = todoController.listAllTodos(new ModelMap());

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("JSP_ListTodos", result);
  }

  @Test
  void test_showNewTodoPage_thenOk() {
    // when
    String result = todoController.showNewTodoPage(new ModelMap());

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("JSP_Todo", result);
  }

  @Test
  void test_addNewTodo_thenOk() {
    // when
    BindingResult bindingResult = Mockito.mock(BindingResult.class);
    when(bindingResult.hasErrors()).thenReturn(false);
    when(todoRepository.save(any())).thenReturn(null);

    String result = todoController.addNewTodo(todoTest, bindingResult);

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("redirect:list-todos", result);
    Assertions.assertEquals("test", todoTest.getUsername());

    verify(todoRepository, times(1)).save(any());
  }

  @Test
  void test_addNewTodoButBindingResultHasErrors_thenOk() {
    // when
    BindingResult bindingResult = Mockito.mock(BindingResult.class);
    when(bindingResult.hasErrors()).thenReturn(true);

    String result = todoController.addNewTodo(todoTest, bindingResult);

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("JSP_Todo", result);
    Assertions.assertEquals("username", todoTest.getUsername());

    verify(todoRepository, times(0)).save(any());
  }

  @Test
  void test_deleteById_thenOk() {
    // when
    doNothing().when(todoRepository).deleteById(anyInt());

    String result = todoController.deleteTodo(1);

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("redirect:list-todos", result);
  }

  @Test
  void test_showUpdateTodo_thenOk() {
    // when
    when(todoRepository.findById(anyInt())).thenReturn(Optional.of(todoTest));
    when(todoRepository.save(any())).thenReturn(null);

    String result = todoController.showUpdateTodo(1, new ModelMap());

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("JSP_Todo", result);

    verify(todoRepository, times(1)).findById(anyInt());
    verify(todoRepository, times(1)).save(any());
  }

  @Test
  void test_updateTodo_thenOk() {
    // when
    BindingResult bindingResult = Mockito.mock(BindingResult.class);
    when(bindingResult.hasErrors()).thenReturn(false);
    when(todoRepository.save(any())).thenReturn(null);

    String result = todoController.updateTodo(todoTest, bindingResult);

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("redirect:list-todos", result);
    Assertions.assertEquals("test", todoTest.getUsername());

    verify(todoRepository, times(1)).save(any());
  }

  @Test
  void test_updateTodoButBindingResultHasErrors_thenOk() {
    // when
    BindingResult bindingResult = Mockito.mock(BindingResult.class);
    when(bindingResult.hasErrors()).thenReturn(true);

    String result = todoController.updateTodo(todoTest, bindingResult);

    // then
    Assertions.assertNotNull(result);
    Assertions.assertEquals("JSP_Todo", result);
    Assertions.assertEquals("username", todoTest.getUsername());

    verify(todoRepository, times(0)).save(any());
  }

}
