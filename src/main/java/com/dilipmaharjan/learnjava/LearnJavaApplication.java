package com.dilipmaharjan.learnjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LearnJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnJavaApplication.class, args);
	}

}
