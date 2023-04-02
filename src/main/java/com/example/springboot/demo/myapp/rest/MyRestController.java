package com.example.springboot.demo.myapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello(){
        return "Hello World from MyRestController!";
    }

}
