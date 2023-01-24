package com.in28minutes.springboot.springbootwebapp.security;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Security utility class.
 */
public class SecurityUtils {

  private SecurityUtils() {
  }

  public static String getLoggedInUser() {
    return SecurityContextHolder.getContext()
        .getAuthentication()
        .getName();
  }
}
