package com.in28minutes.springboot.springbootwebapp.service;

import org.springframework.stereotype.Service;

/**
 * Authentication Service to validate the user.
 */
@Service
public class AuthenticationService {

  public boolean isValid(String name, String password) {
    return name.equalsIgnoreCase("in28minutes")
        && password.equalsIgnoreCase("dummy");
  }

}
