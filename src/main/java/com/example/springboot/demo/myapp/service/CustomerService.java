package com.example.springboot.demo.myapp.service;

import com.example.springboot.demo.myapp.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer save(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();

    List<Customer> findByLastName(String lastName);

    void update(Customer customer);

    void deleteById(Integer id);

    int deleteAll();
}
