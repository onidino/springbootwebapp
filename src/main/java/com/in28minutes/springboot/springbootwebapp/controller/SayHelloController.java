package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHelloController {


  @GetMapping("say-hello")
  public String sayHello() {
    return "Hello! What are you learning today?";
  }

  @GetMapping("say-hello-html")
  public String sayHelloHtml() {
    return Utils.getResourceFileAsString("sayhello.html");
  }

}
