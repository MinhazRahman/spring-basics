package com.example.springboot.demo.myapp;

import com.example.springboot.demo.myapp.dao.CustomerDAO;
import com.example.springboot.demo.myapp.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	// Java bean to run command line application
	@Bean
	public CommandLineRunner commandLineRunner(CustomerDAO customerDAO){ // inject customerDAO
		return runner ->{
			// System.out.println("Hello World");
			// createCustomer(customerDAO);
			// readCustomer(customerDAO);
			// readAllCustomers(customerDAO);
			readCustomerByLastName(customerDAO);
		};
	}

	private void readCustomerByLastName(CustomerDAO customerDAO) {
		// create the customer object
		System.out.println("Creating the customer object...");
		Customer customer = new Customer("Jonny", "Doe", "jonny@example.com");

		// save the customer object
		System.out.println("Saving the customer object...");
		customerDAO.save(customer);

		// retrieve all the customers by last name
		List<Customer>  customerList = customerDAO.findByLastName(customer.getLastName());

		// display customers
		for (Customer theCustomer: customerList){
			System.out.println(theCustomer);
		}
	}

	private void readAllCustomers(CustomerDAO customerDAO) {
		// retrieve all the customers
		List<Customer>  customerList = customerDAO.findAll();

		// display customers
		for (Customer customer: customerList){
			System.out.println(customer);
		}
	}

	private void readCustomer(CustomerDAO customerDAO) {
		// create the customer object
		System.out.println("Creating the customer object...");
		Customer customer = new Customer("Jonny", "Doe", "jonny@example.com");

		// save the customer object
		System.out.println("Saving the customer object...");
		customerDAO.save(customer);

		// retrieve the customer object from the DB
		Customer theCustomer = customerDAO.findById(customer.getId());

		// display the customer
		System.out.println(customer);
	}

	private void createCustomer(CustomerDAO customerDAO) {
		// create the customer object
		System.out.println("Creating the customer object...");
		Customer customer = new Customer("Jammy", "Doe", "jammy@example.com");

		// save the customer object
		System.out.println("Saving the customer object...");
		customerDAO.save(customer);

		// display the id of the customer object
		System.out.println("Saved Customer, Generated id: " + customer.getId());
	}

}
