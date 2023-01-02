package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Login Controller to validate the user credentials.
 */
@Controller
@SessionAttributes("name")
public class LoginController {

  private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

  private final AuthenticationService authenticationService;

  @Autowired
  public LoginController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  // URL: /login?name=NAME
  @GetMapping(value = "login")
  public String gotoLoginPage(@RequestParam(required = false) String name, ModelMap model) {
    LOGGER.debug("LOG query_param: name = {}", name != null ? name : "null");

    model.put("name", name);
    return "JSP_Login";
  }

  @PostMapping(value = "login")
  public String gotoWelcomePage(
      @RequestParam String name, @RequestParam String password, ModelMap model) {

    if (authenticationService.isValid(name, password)) {
      model.put("name", name);
      return "JSP_Welcome";
    }
    model.put("errorMsg", "Invalid Credentials - Please try again!");
    return "JSP_Login";
  }
}
