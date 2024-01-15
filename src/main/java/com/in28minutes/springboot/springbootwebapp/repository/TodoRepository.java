package com.in28minutes.springboot.springbootwebapp.repository;

import com.in28minutes.springboot.springbootwebapp.entities.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * To-do jpa repository with all the methods to get the todos from the database.
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {

  public List<Todo> findByUsername(String username);
}
