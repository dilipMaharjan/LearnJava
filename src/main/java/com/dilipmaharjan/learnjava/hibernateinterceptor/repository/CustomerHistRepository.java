package com.dilipmaharjan.learnjava.hibernateinterceptor.repository;

import org.springframework.data.repository.CrudRepository;

import com.dilipmaharjan.learnjava.hibernateinterceptor.domain.CustomerHist;

public interface CustomerHistRepository extends CrudRepository<CustomerHist, Long> {

}
