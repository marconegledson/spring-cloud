package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/server")
public class SleuthServerEndpoint {

	private static Logger LOGGER = LoggerFactory.getLogger(SleuthServerEndpoint.class);

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello")
	public String hello() {
		LOGGER.info("Antes de chamar o client ");
		String response = restTemplate.getForObject("http://localhost:8081/client/hello", String.class);
		LOGGER.info("Depois de chamar o client");
		return response;

	}

}
