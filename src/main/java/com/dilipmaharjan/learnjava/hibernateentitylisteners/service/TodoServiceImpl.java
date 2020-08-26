package com.dilipmaharjan.learnjava.hibernateentitylisteners.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilipmaharjan.learnjava.hibernateentitylisteners.domain.Todo;
import com.dilipmaharjan.learnjava.hibernateentitylisteners.repository.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;

	@Override
	public Todo add(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Todo update(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public void delete(Long id) {
		todoRepository.deleteById(id);
	}

	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}

	@Override
	public Todo findById(Long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		if (!todo.isPresent())
			throw new RuntimeErrorException(null, "Not found");
		return todo.get();
	}

}
