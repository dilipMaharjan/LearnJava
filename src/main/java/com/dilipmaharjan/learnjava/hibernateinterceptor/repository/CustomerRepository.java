package com.dilipmaharjan.learnjava.hibernateinterceptor.repository;

import org.springframework.data.repository.CrudRepository;

import com.dilipmaharjan.learnjava.hibernateinterceptor.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
