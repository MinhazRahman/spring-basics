package com.example.springboot.demo.myapp.rest;

import com.example.springboot.demo.myapp.entity.Customer;
import com.example.springboot.demo.myapp.service.CustomerService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // Define CustomerDAO field
    private CustomerService customerService;
    private List<Customer> customers;

    // define @PostConstruct annotation to load customer data, only once.
    @PostConstruct
    public void loadData(){ // load data only once
        // retrieve all the customers
        customers = customerService.findAll();
    }

    // Inject CustomerDAO into the CustomerRestController using constructor injection
    @Autowired
    public CustomerRestController(CustomerService customerService){
        this.customerService = customerService;
    }

    /**
     * define endpoint for GET "/customers"
     * Returns a list of customers
     * */
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customers;
    }

    /**
     * Define endpoint for GET "/customer/{customerId}"
     * Returns the customer
     * */
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.findById(customerId);

        if (customer == null){
            throw new RuntimeException("Customer not found with id - " + customerId);
        }
        return customer;
    }

    /**
     * Define endpoint for POST "/customers"
     * ADD the customer into the database
     * */
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        // just in case we pass an id with Json - set the id to 0
        // this is to force a save of the item - instead of update
        customer.setId(0);
        // save the Customer, if id == 0, then save/insert otherwise update
        Customer dbCustomer = customerService.save(customer);
        // return the saved customer
        return dbCustomer;
    }

    /**
     * Define endpoint for PUT "/customers"
     * ADD the customer into the database
     * */
    public Customer updateCustomer(@RequestBody Customer customer){
        // save the Customer, if id == 0, then save/insert otherwise update
        Customer dbCustomer = customerService.save(customer);

        // return the updated customer
        return dbCustomer;
    }

    /**
     * Define endpoint for "/customers/{customerId}"
     * Deletes the customer from the database
     * */
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.findById(customerId);
        if (customer == null){
            throw new RuntimeException("Customer id not found - " + customerId);
        }
        customerService.deleteById(customerId);
        return "Deleted customer with id -" + customerId;
    }
}
