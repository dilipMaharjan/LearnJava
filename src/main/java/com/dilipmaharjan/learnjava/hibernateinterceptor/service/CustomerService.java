package com.dilipmaharjan.learnjava.hibernateinterceptor.service;

import com.dilipmaharjan.learnjava.hibernateinterceptor.domain.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	void deleteCustomer(Long id);
}
