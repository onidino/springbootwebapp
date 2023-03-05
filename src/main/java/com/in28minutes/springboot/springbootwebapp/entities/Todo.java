package com.in28minutes.springboot.springbootwebapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Todo")
public class Todo {

  @Id
  @GeneratedValue
  private int id;
  private String username;
  @Size(min = 10, message = "Enter at least 10 characters")
  private String description;
  private LocalDate targetDate;
  private boolean done;

  protected Todo() {
  }

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

