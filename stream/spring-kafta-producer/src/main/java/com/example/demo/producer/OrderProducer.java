package com.example.demo.producer;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class OrderProducer {
	
	@Value("${order.topic}")
	private String orderTopic;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void send(@RequestBody String order) {
		kafkaTemplate.send(orderTopic, UUID.randomUUID().toString(), order);
	}

}
