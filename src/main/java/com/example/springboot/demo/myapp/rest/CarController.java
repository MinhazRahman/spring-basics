package com.example.springboot.demo.myapp.rest;

import com.example.springboot.demo.myapp.common.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    Car myCar;

    @Autowired
    public CarController(Car myCar){ // constructor injection
        this.myCar = myCar;
    }

    @GetMapping("/car/name")
    public String getName(){
        return myCar.getName();
    }
}
