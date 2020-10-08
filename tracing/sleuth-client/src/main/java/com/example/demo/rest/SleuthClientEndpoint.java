package com.example.demo.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class SleuthClientEndpoint {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SleuthClientEndpoint.class);
	
	@GetMapping("/hello")
	public String hello(){
        LOGGER.info("Reached Client");
        return "Hello World";
    }

}
