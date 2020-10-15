package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderConsumer {
	
	@KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
	public void consumer(String order) {
        log.info("Order: " + order);
    }
	
	
}
