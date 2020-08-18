package com.dilipmaharjan.learnjava.envers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilipmaharjan.learnjava.envers.domain.EmployeeHist;
import com.dilipmaharjan.learnjava.envers.repository.EmployeeHistRepository;

@Service
public class EmployeeHistImpl implements EmployeeHistService {
	@Autowired
	private EmployeeHistRepository employeeHistRepository;

	@Override
	public List<EmployeeHist> getEmployeHistory() {
		return employeeHistRepository.findAll();
	}

}
