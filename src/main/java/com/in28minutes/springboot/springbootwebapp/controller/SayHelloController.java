package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller class
 */
@Controller
public class SayHelloController {

  @GetMapping("say-hello")
  @ResponseBody
  public String sayHello() {
    return "Hello! What are you learning today?";
  }

  @GetMapping("say-hello-html")
  @ResponseBody
  public String sayHelloHtml() {
    return Utils.getResourceHtml("sayhello-html");
  }

  @RequestMapping("say-hello-jsp")
  public String sayHelloJsp() {
    return "sayHello";
  }

}
