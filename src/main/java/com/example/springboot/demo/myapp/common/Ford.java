package com.example.springboot.demo.myapp.common;

import org.springframework.stereotype.Component;

@Component
public class Ford implements Car{
    @Override
    public String getName() {
        return "Ford";
    }

    @Override
    public String getModel() {
        return null;
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
