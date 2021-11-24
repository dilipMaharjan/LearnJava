package com.dilipmaharjan.learnjava;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dilip
 */
@Service
public class TodoService {
    public List<Todo> getTodos() {
        return Arrays.asList(Todo.builder().title("AOP").description("Write Aop for exception").build());
    }
}
