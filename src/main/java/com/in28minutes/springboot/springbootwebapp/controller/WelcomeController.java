package com.in28minutes.springboot.springbootwebapp.controller;

import com.in28minutes.springboot.springbootwebapp.security.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Login Controller to validate the user credentials.
 */
@Controller
@SessionAttributes("name")
public class WelcomeController {

  /**
   * Redirects the user to the home page JSP_Welcome.
   *
   * @param model the modelmap
   * @return the view page JSP_Welcome.
   */
  @GetMapping(value = "/")
  public String gotoWelcomePage(
      ModelMap model) {

    model.put("name", SecurityUtils.getLoggedInUser());
    return "JSP_Welcome";
  }

}
