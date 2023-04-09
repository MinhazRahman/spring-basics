package com.example.springboot.demo.myapp.config;

import com.example.springboot.demo.myapp.common.Audi;
import com.example.springboot.demo.myapp.common.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.engine.spi.SessionLazyDelegator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configure Java beans
@Configuration
public class BeanConfig {

    @Bean
    public Car audi(){
        return new Audi();
    }
}
