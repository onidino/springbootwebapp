package com.in28minutes.springboot.springbootwebapp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import com.in28minutes.springboot.springbootwebapp.security.SecurityUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.ui.ModelMap;

class WelcomeControllerTest {

  private WelcomeController welcomeController;

  @BeforeEach
  void initBefore() {
    this.welcomeController = new WelcomeController();
  }

  @Test
  void when_gotoWelcomePage_testOk() {
    MockedStatic<SecurityUtils> securityUtilsMocked = mockStatic(SecurityUtils.class);
    securityUtilsMocked.when(SecurityUtils::getLoggedInUser).thenReturn("bar");
    assertEquals("bar", SecurityUtils.getLoggedInUser());

    String result = welcomeController.gotoWelcomePage(new ModelMap());

    Assertions.assertNotNull(result);
    Assertions.assertEquals("JSP_Welcome", result);
    securityUtilsMocked.close();
  }
}