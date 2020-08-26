package com.dilipmaharjan.learnjava.hibernateentitylisteners.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.dilipmaharjan.learnjava.hibernateentitylisteners.domain.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
//	@Query(value = "SELECT * FROM TODO", nativeQuery = true)
	@Query("select todo from Todo todo")
	public List<Todo> findAll();
}

