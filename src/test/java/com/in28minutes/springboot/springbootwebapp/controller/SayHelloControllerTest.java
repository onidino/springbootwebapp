package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.utils.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SayHelloControllerTest {

  private final SayHelloController sayHelloController = new SayHelloController();

  @Test
  void test_sayHello() {
    String result = sayHelloController.sayHello();

    Assertions.assertEquals("Hello! What are you learning today?", result);
  }

  @Test
  void test_sayHelloHtml() {
    String result = sayHelloController.sayHelloHtml();

    Assertions.assertEquals(Utils.getResourceHtml("sayhello-html"), result);
  }

  @Test
  void test_sayHelloJsp() {
    String result = sayHelloController.sayHelloJsp();

    Assertions.assertEquals("JSP_SayHello", result);
  }

}
