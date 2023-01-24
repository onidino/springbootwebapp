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
    UnaryOperator<String> passwordEncoder =
        input -> getPasswordEncoder().encode(input);

    UserDetails userDetails = User.builder()
        .passwordEncoder(passwordEncoder)
        .username("in28minutes")
        .password("dummy")
        .roles("USER", "ADMIN")
        .build();

    return new InMemoryUserDetailsManager(userDetails);
  }

  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
