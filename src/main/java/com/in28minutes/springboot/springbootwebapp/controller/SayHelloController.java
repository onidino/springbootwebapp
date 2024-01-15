package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Say hello controller class.
 */
@Controller
public class SayHelloController {

  /**
   * URL: /say-hello
   *
   * @return hello message
   */
  @GetMapping("say-hello")
  @ResponseBody
  public String sayHello() {
    return "Hello! What are you learning today?";
  }

  /**
   * URL: /say-hello-html
   *
   * @return sayhello-html page
   */
  @GetMapping("say-hello-html")
  @ResponseBody
  public String sayHelloHtml() {
    return Utils.getResourceHtml("sayhello-html");
  }

  /**
   * URL: /say-hello-jsp
   *
   * @return the JSP_SayHello page
   */
  @RequestMapping("say-hello-jsp")
  public String sayHelloJsp() {
    return "JSP_SayHello";
  }

}
