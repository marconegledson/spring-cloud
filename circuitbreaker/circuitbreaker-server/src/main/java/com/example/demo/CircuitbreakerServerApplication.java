package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@EnableCircuitBreaker
@SpringBootApplication
public class CircuitbreakerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitbreakerServerApplication.class, args);
	}

}
