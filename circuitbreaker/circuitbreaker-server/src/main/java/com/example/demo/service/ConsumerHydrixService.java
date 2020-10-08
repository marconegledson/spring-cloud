package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ConsumerHydrixService {
	
	@Value("${endpoint.target}")
	private String endpointTarget;

	@HystrixCommand(fallbackMethod = "fallback")
	public String message() {
		 return new RestTemplate().getForObject(endpointTarget, String.class);
	}
	
	public String fallback() {
        return "fallback call";
    }

}
