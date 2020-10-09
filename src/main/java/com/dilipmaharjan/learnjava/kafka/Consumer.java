package com.dilipmaharjan.learnjava.kafka;

import java.time.Duration;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consumer {

	public static void main(String[] args) {

		// set kafka properties
		Properties properties = new Properties();
		String bootstrapServers = "127.0.0.1:9092";

		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "group-one");
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		// create consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

		// subscribe to a topic
		consumer.subscribe(Arrays.asList("first_topic"));

		// poll for new data
		boolean breakLoop = true;
		while (breakLoop) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

			records.forEach(record -> {
				log.info("Key " + record.key());
				log.info("Value " + record.value());
				log.info("Partition " + record.partition());
				log.info("Offset " + record.offset());
			});

			breakLoop = false;
		}
	}

}
