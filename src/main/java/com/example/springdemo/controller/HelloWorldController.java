package com.example.springdemo.controller;

import com.example.springdemo.entity.User;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Hello World", description = "Tutorial management APIs")
@RestController
public class HelloWorldController {

    @RequestMapping (value = "/hello", method = RequestMethod.GET)
    public  String getHello(@RequestParam(value = "nickname", required = false) String nickname) {
        if(nickname==null){
            return "<p style=\"background-color:yellow; color:red\">hello world</p>";
        }
        else {
            return String.format("<p style=\"background-color:yellow; color:red\">hello world%s</p>", nickname);
        }
    }

    @RequestMapping (value = "/login", method = RequestMethod.POST)
    public  String login(User user) {
        return user.getUsername() + "  " + user.getPassword();
    }
}
