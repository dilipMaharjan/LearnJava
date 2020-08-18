package com.dilipmaharjan.learnjava.envers.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dilipmaharjan.learnjava.envers.domain.EmployeeHist;

public interface EmployeeHistRepository extends CrudRepository<EmployeeHist, Long> {
	List<EmployeeHist> findAll();
}
