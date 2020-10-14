package com.example.demo.restcontroller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FahrenheitRestController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/fahrenheit/{value}")
	public double convert(@PathVariable(required = true) double value) {
		return (value - 32) / 1.8;
	}
	
	@GetMapping("/hello")
	public String hello() throws UnknownHostException {
		return String.format("I'm running in %s:%s", InetAddress.getLocalHost().getHostAddress(), environment.getProperty("local.server.port"));
	}

}
