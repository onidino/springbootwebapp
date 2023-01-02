package com.in28minutes.springboot.springbootwebapp.todo;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class Todo {

  private final int id;
  private final String username;
  private final String description;
  private final LocalDate targetDate;
  private final boolean done;

  public Todo(int id, String username, String description, LocalDate targetDate, boolean done) {
    this.id = id;
    this.username = username;
    this.description = description;
    this.targetDate = targetDate;
    this.done = done;
  }

  @Override
  public String toString() {
    return "Todo{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", description='" + description + '\'' +
        ", targetDate=" + targetDate +
        ", done=" + done +
        '}';
  }
}
