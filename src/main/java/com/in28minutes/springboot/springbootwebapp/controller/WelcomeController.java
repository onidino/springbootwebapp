package com.in28minutes.springboot.springbootwebapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Login Controller to validate the user credentials.
 */
@Controller
@SessionAttributes("name")
public class WelcomeController {

  private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

  // URL: /login?name=NAME
  @GetMapping(value = "/")
  public String gotoWelcomePage(@RequestParam(required = false) String name, ModelMap model) {
    LOGGER.debug("LOG query_param: name = {}", name != null ? name : "null");
    model.put("name", "in28minutes");
    return "JSP_Welcome";
  }
}
