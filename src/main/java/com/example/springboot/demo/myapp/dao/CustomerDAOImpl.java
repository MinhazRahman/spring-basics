package com.example.springboot.demo.myapp.dao;

import com.example.springboot.demo.myapp.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
    // define the entity manager field
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement the save method
    @Override
    @Transactional
    public void save(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = entityManager.find(Customer.class, id); // retrieve customer from the DB
        return customer;
    }
}
