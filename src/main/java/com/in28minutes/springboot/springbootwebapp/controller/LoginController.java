package com.in28minutes.springboot.springbootwebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Login Controller.
 */
@Controller
public class LoginController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  // URL: /login?name=NAME
  @GetMapping(value = "login")
  public String gotoLoginPage(@RequestParam(required = false) String name, ModelMap model) {
    LOGGER.debug("LOG query_param: name = {}", name != null ? name : "null");

    model.put("name", name);
    return "login";
  }

  @PostMapping(value = "login")
  public String gotoWelcomePage(
      @RequestParam String name, @RequestParam String password, ModelMap model) {
    model.put("name", name);
    model.put("password", password);
    return "welcome";
  }
}
