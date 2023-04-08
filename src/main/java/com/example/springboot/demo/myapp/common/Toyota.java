package com.example.springboot.demo.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class Toyota implements Car{

    public Toyota(){
        System.out.println("In the constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getName() {
        return "Toyota";
    }

    @Override
    public String getModel() {
        return "Toyota - A3";
    }

    @Override
    public String getYear() {
        return null;
    }

    @Override
    public String getColor() {
        return null;
    }
}
