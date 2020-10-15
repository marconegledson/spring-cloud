package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.producer.OrderProducer;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderProducer producer;
	
	@GetMapping("/{order}")
	public void send(@PathVariable(required = true) String order) {
		producer.send(order);
	}

}
