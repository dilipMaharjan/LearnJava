package com.dilipmaharjan.learnjava.spring.kafka.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {

	private Integer id;
	private String name;
	private String author;
}
