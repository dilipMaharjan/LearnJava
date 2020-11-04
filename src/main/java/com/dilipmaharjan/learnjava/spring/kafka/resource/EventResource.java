package com.dilipmaharjan.learnjava.spring.kafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dilipmaharjan.learnjava.spring.kafka.domain.Event;
import com.dilipmaharjan.learnjava.spring.kafka.producer.EventProducer;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class EventResource {

	@Autowired
	private EventProducer eventProducer;

	@PostMapping("/events")
	public ResponseEntity<Event> produceEvent(@RequestBody Event event) throws JsonProcessingException {

		// produce event
		eventProducer.produceEvent(event);

		return ResponseEntity.status(HttpStatus.CREATED).body(event);
	}
}
