package com.example.springboot.demo.myapp.rest;

import com.example.springboot.demo.myapp.dao.CustomerDAO;
import com.example.springboot.demo.myapp.entity.Customer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        return customerDAO.findById(customerId);
    }

    /**
     * Define endpoint for "/customers/{customerId}"
     * Deletes the customer from the database
     * */
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerDAO.findById(customerId);
        if (customer == null){
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        customerDAO.deleteById(customerId);
        return "Deleted customer with id -" + customerId;
    }
}
