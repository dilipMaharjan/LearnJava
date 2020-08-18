package com.dilipmaharjan.learnjava.envers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dilipmaharjan.learnjava.envers.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	List<Employee> findAll();

}
