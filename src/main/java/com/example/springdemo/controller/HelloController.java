package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public  String hello() {
        return "<p style=\"background-color:yellow; color:red\">hello world</p>";
    }

}
