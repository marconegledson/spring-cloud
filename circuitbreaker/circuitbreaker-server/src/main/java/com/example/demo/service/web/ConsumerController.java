package com.example.demo.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ConsumerHydrixService;
import com.example.demo.service.ConsumerRetryService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	@Autowired
	private ConsumerHydrixService consumerHydrixService;
	
	@Autowired
	private ConsumerRetryService consumerRetryService;
	
	@GetMapping("/hydrix/")
	public String message() {
		return consumerHydrixService.message();
	}
	
	@GetMapping("/retry/")
	public String message2() {
		return consumerRetryService.message();
	}

}