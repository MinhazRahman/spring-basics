package com.example.springboot.demo.myapp.rest;

import com.example.springboot.demo.myapp.dao.CustomerDAO;
import com.example.springboot.demo.myapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // Define CustomerDAO field
    CustomerDAO customerDAO;

    // Inject CustomerDAO into the CustomerRestController using constructor injection
    @Autowired
    public CustomerRestController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    /**
     * define endpoint for "/students"
     * Returns a list of students
     * */
    @GetMapping("/students")
    public List<Customer> getStudents(){
        // retrieve all the customers
        List<Customer> customers = customerDAO.findAll();
        return customers;
    }
}
