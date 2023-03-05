package com.in28minutes.springboot.springbootwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.UnaryOperator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

  private UserDetails createNewUser(
      final String username, final String password) {

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

  @Bean
  public SecurityFilterChain filterChain(
      final HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(auth ->
        auth.anyRequest().authenticated());
    http.formLogin(withDefaults());
    http.csrf().disable();
    http.headers().frameOptions().disable();

    return http.build();
  }

}
