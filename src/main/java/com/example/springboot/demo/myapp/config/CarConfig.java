package com.example.springboot.demo.myapp.config;

import com.example.springboot.demo.myapp.common.Audi;
import com.example.springboot.demo.myapp.common.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configure Java beans
@Configuration
public class CarConfig {

    @Bean
    public Car audi(){
        return new Audi();
    }
}
