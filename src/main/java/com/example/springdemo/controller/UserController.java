package com.example.springdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public String getUserInfoById(@PathVariable int id){
        System.out.println(id);
        return "getUserInfoById";
    }

}
