package com.dilipmaharjan.learnjava.hibernateentitylisteners.service;

import java.util.List;

import org.springframework.stereotype.Indexed;

@Indexed
public interface CrudService<T> {
	public T add(T t);

	public T update(T t);

	public void delete(Long id);

	public List<T> findAll();

	public T findById(Long id);
}
