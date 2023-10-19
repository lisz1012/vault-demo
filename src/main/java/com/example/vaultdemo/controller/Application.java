package com.example.vaultdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
//@RestController
public class Application {

  @Value("${password}")
  String name = "World";

  @RequestMapping("/")
  public String home() {
    return "Hello " + name;
  }

}