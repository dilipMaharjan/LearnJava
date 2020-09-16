package com.dilipmaharjan.learnjava.spring.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.dilipmaharjan.learnjava.spring.kafka.domain.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EventProducer {

	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;

	@Autowired
	ObjectMapper mapper;

	public void produceEvent(Event event) throws JsonProcessingException {

		Integer key = event.getId();
		String value = mapper.writeValueAsString(event.getBook());
		ListenableFuture<SendResult<Integer, String>> eventState = kafkaTemplate.sendDefault(key, value);

		eventState.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {

				handleSuccess(key, value, result);
			}

			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key, value, ex);
			}

		});
	}

	private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
		log.info("Message sent successfully for key : {} and value is {}, partition is {} and topic is {}", key, value,
				result.getRecordMetadata().partition(),result.getRecordMetadata().topic());
	}

	private void handleFailure(Integer key, String value, Throwable ex) {
		log.error("Error sending message and exception is  {}", ex.getMessage());
		try {
			throw ex;
		} catch (Throwable throwable) {
			log.error("Error in OnFailure : ", throwable.getMessage());
		}
	}

}
