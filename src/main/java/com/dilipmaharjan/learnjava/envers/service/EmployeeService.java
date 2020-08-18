package com.dilipmaharjan.learnjava.envers.service;

import java.util.List;

import com.dilipmaharjan.learnjava.envers.domain.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getEmployees();

	Employee updateEmployee(Employee employee);

	void deleteEmplyee(Long id);
}
