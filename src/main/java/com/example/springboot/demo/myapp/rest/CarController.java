package com.example.springboot.demo.myapp.rest;

import com.example.springboot.demo.myapp.common.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    Car myCar;

    @Autowired
    public CarController(@Qualifier("audi") Car myCar){ // constructor injection
        System.out.println("In the constructor: " + getClass().getSimpleName());
        this.myCar = myCar;
    }

    /**
    @Autowired
    public void setCar(@Qualifier("toyota") Car myCar){ // setter injection
        this.myCar = myCar;
    }
    */

    @GetMapping("/car/name")
    public String getName(){
        return myCar.getName();
    }

    @GetMapping("/car/model")
    public String getModel(){
        return myCar.getModel();
    }
}
