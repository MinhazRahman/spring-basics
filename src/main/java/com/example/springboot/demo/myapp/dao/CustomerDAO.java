package com.example.springboot.demo.myapp.dao;

import com.example.springboot.demo.myapp.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    void save(Customer customer);

    Customer findById(Integer id);

    List<Customer> findAll();
}
