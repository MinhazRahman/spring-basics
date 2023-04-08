package com.example.springboot.demo.myapp.common;

// No @component annotation
public class Audi implements Car{

    public Audi(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getName() {
        return "Audi";

    }

    @Override
    public String getModel() {
        return "Audi - 1013";
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
