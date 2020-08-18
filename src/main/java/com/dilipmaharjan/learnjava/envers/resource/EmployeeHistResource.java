package com.dilipmaharjan.learnjava.envers.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.learnjava.envers.domain.EmployeeHist;
import com.dilipmaharjan.learnjava.envers.service.EmployeeHistService;

@RestController
@RequestMapping("/emphist")
public class EmployeeHistResource {

	@Autowired
	private EmployeeHistService employeeHistService;

	@GetMapping
	public List<EmployeeHist> getHistory() {
		return employeeHistService.getEmployeHistory();
	}
}
