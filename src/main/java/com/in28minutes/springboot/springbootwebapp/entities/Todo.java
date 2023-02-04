package com.in28minutes.springboot.springbootwebapp.entities;

import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Todo {

  private int id;
  private String username;
  @Size(min = 10, message = "Enter at least 10 characters")
  private String description;
  private LocalDate targetDate;
  private boolean done;

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
