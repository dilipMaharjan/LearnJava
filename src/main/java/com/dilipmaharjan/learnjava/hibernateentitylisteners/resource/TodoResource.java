package com.dilipmaharjan.learnjava.hibernateentitylisteners.resource;

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

import com.dilipmaharjan.learnjava.hibernateentitylisteners.domain.Todo;
import com.dilipmaharjan.learnjava.hibernateentitylisteners.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoResource {

	@Autowired
	private TodoService todoService;

	@PostMapping
	public Todo add(@RequestBody Todo todo) {
		return todoService.add(todo);
	}

	@GetMapping
	public List<Todo> getAll() {
		return todoService.findAll();
	}

	@GetMapping("/{id}")
	public Todo getOne(@PathVariable Long id) {
		return todoService.findById(id);
	}

	@PutMapping
	public Todo update(@RequestBody Todo todo) {
		return todoService.update(todo);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		todoService.delete(id);
	}

}
