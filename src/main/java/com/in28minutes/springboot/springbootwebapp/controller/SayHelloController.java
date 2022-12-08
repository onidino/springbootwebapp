package com.in28minutes.springboot.springbootwebapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {

  @GetMapping("say-hello")
  public String sayHello() {
    return "Hello! What are you learning today?";
  }

}
