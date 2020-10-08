package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Value("${server.port}")
	public int port;
	
	@GetMapping("/")
	public String message() {
		return appName + " is executing in port " + port;
	}
	
	@GetMapping("/consumer/3")
	public String consumer() {
		return "Consumer3 in  "+appName+ ":" + port;
	}

}
