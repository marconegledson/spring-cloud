package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	private int counter;
	
	@GetMapping("/")
	public String retry() {
		counter++;
		if(counter % 2 == 0) throw new RuntimeException("retry doesnt work");
		return  "retry works";
	}

}