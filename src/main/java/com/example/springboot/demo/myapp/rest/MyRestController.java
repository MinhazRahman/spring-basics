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

    // expose "/name" endpoint
    @GetMapping("/name")
    public String getName(){
        return "Mohammed Rahman";
    }

    // expose "/address" endpoint
    @GetMapping("/address")
    public String getAddress(){
        return "New York, NY - 10017";
    }


}
