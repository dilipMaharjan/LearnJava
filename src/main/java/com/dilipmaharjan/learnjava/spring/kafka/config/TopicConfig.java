package com.dilipmaharjan.learnjava.spring.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

	@Bean
	public NewTopic createTopic() {
		return TopicBuilder.name("events").partitions(2).replicas(1).build();
	}
}
