package com.example.springboot.demo.myapp.rest;

import com.example.springboot.demo.myapp.dao.CustomerDAO;
import com.example.springboot.demo.myapp.entity.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // Define CustomerDAO field
    CustomerDAO customerDAO;
    List<Customer> customers;

    // define @PostConstruct annotation to load customer data, only once.
    @PostConstruct
    public void loadData(){ // load data only once
        // retrieve all the customers
        customers = customerDAO.findAll();
    }

    // Inject CustomerDAO into the CustomerRestController using constructor injection
    @Autowired
    public CustomerRestController(CustomerDAO customerDAO){
        this.customerDAO = customerDAO;
    }

    /**
     * define endpoint for "/customers"
     * Returns a list of customers
     * */
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * Define endpoint for "/customer/{customerId}"
     * Returns the customer
     * */
    @GetMapping("/customer/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        return customerDAO.findById(customerId);
    }
}
