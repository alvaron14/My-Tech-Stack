package com.alvaro.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication(scanBasePackages = "com.alvaro")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
