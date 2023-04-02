package com.example.springboot.demo.myapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    // inject properties for: user.greeting, user.nickname, user.address
    @Value("${user.greeting}")
    private String userGreeting;
    @Value("${user.nickname}")
    private String userName;
    @Value("${user.address}")
    private String userAddress;

    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return userGreeting;
    }

    // expose "/name" endpoint
    @GetMapping("/name")
    public String getName(){
        return userName;
    }

    // expose "/address" endpoint
    @GetMapping("/address")
    public String getAddress(){
        return userAddress;
    }


}
