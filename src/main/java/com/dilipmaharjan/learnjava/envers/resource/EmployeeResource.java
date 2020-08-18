package com.dilipmaharjan.learnjava.envers.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.learnjava.envers.domain.Employee;
import com.dilipmaharjan.learnjava.envers.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeResource {
	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody Employee employee) {
		return employeeService.updateEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmplyee(id);
	}

}
