package com.dilipmaharjan.learnjava.hibernateinterceptor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.learnjava.hibernateinterceptor.domain.Customer;
import com.dilipmaharjan.learnjava.hibernateinterceptor.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerResource {
	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);

	}

	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);

	}

	@DeleteMapping("/{id}")
	public void updateCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
	}
}
