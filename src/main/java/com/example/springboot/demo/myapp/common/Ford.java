package com.example.springboot.demo.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class Ford implements Car{

    public Ford(){
        System.out.println("In the constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getName() {
        return "Ford";
    }

    @Override
    public String getModel() {
        return "Ford - A4";
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
