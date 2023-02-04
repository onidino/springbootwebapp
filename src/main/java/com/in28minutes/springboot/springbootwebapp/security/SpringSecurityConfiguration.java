package com.in28minutes.springboot.springbootwebapp.security;

import java.util.function.UnaryOperator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Configuration class for spring security.
 */
@Configuration
public class SpringSecurityConfiguration {

  @Bean
  public InMemoryUserDetailsManager createUserDetailsManager() {
    UserDetails user28 = createNewUser("in28minutes", "dummy");
    UserDetails userDino = createNewUser("dino", "123");

    return new InMemoryUserDetailsManager(user28, userDino);
  }

  private UserDetails createNewUser(String username, String password) {
    UnaryOperator<String> passwordEncoder =
        input -> getPasswordEncoder().encode(input);

    return User.builder()
        .passwordEncoder(passwordEncoder)
        .username(username)
        .password(password)
        .roles("USER", "ADMIN")
        .build();
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
