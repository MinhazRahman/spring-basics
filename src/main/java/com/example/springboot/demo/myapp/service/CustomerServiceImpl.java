package com.example.springboot.demo.myapp.service;

import com.example.springboot.demo.myapp.dao.CustomerDAO;
import com.example.springboot.demo.myapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerDAO customerDAO;

    // inject CustomerDAO using constructor injection
    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public Customer save(Customer customer) {
        return customerDAO.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerDAO.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        return customerDAO.findByLastName(lastName);
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        customerDAO.deleteById(id);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return customerDAO.deleteAll();
    }
}
