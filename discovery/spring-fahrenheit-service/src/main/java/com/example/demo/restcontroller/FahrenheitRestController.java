package com.example.demo.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FahrenheitRestController {
	
	@GetMapping("/fahrenheit/{value}")
	public double convert(@PathVariable(required = true) double value) {
		return (value - 32) / 1.8;
	}

}
