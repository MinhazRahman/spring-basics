package com.example.springboot.demo.myapp.dao;

import com.example.springboot.demo.myapp.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.QTypeContributor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Customer save(Customer customer) {

        // save the Customer, if id == 0, then save/insert otherwise update
        Customer dbCustomer = entityManager.merge(customer);

        return dbCustomer;
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = entityManager.find(Customer.class, id); // retrieve customer from the DB
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> typedQuery = entityManager.createQuery("FROM Customer", Customer.class);
        List<Customer> customerList = typedQuery.getResultList();

        return customerList;
    }

    @Override
    public List<Customer> findByLastName(String lastName) {
        TypedQuery<Customer> typedQuery = entityManager.createQuery("FROM Customer WHERE lastName=:lastName", Customer.class);
        typedQuery.setParameter("lastName", lastName);
        List<Customer> customerList = typedQuery.getResultList();

        return customerList;
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        // retrieve the customer
        Customer customer = entityManager.find(Customer.class, id);
        // delete the customer
        entityManager.remove(customer);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Customer").executeUpdate();

        return numRowsDeleted;
    }
}
