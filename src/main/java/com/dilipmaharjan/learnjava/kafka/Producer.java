package com.dilipmaharjan.learnjava.kafka;

import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Producer {

	public static void main(String[] args) {

		// set kafka properties
		Properties properties = new Properties();
		String bootstrapServers = "127.0.0.1:9092";

		properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		// create producer
		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		// create producer record
		ProducerRecord<String, String> record = new ProducerRecord<String, String>("first_topic", "id_0",
				"Hello Kafka");

		// send data
		producer.send(record, new Callback() {

			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				if (null == exception) {
					log.info(
							"Recieved metadata \n" +
									"Topic : " + metadata.topic() + "\n" +
									"Partition : " + metadata.partition() + "\n" +
									"Offset : " + metadata.offset() + "\n" +
									"Timestamp : " + new Date(metadata.timestamp()));
				} else {
					log.error("Error in producing :" + exception.getStackTrace());
				}
			}
		});

		// flush data
		producer.flush();

		// close producer
		producer.close();

	}

}
