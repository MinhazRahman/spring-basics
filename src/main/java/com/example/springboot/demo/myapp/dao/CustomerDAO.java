package com.example.springboot.demo.myapp.dao;

import com.example.springboot.demo.myapp.entity.Customer;

public interface CustomerDAO {
    void save(Customer customer);

    Customer findById(Integer id);
}
