package com.example.demo.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConsumerRetryService {
	
	@Value("${endpoint.target}")
	private String endpointTarget;

	@Retryable(value = RestClientException.class, maxAttempts = 2, backoff = @Backoff(delay = 100))
	public String message() {
		 return new RestTemplate().getForObject(endpointTarget, String.class);
	}

	@Recover
	public String recover(RestClientException e) {
		log.info("Chamado revover: {}", Instant.now());
		return e.getMessage();
	}

}
