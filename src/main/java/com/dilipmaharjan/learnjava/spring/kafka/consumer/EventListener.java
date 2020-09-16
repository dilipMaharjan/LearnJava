package com.dilipmaharjan.learnjava.spring.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventListener {

	@KafkaListener(topics = { "events" })
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
		log.info("Consumer Record : {}", consumerRecord);
	}
}
