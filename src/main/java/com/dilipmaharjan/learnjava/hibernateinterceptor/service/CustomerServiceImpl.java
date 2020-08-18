package com.dilipmaharjan.learnjava.hibernateinterceptor.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilipmaharjan.learnjava.hibernateinterceptor.domain.Customer;
import com.dilipmaharjan.learnjava.hibernateinterceptor.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

}
