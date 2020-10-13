package com.example.demo.restcontroller;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ConverterRestController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/convert/{value}")
	public String convert(@PathVariable(required = true) double value) {
		double fahrenheit = restTemplate.getForObject("http://fahrenheit-service/fahrenheit/{value}", Double.class, value);
		double kelvin = restTemplate.getForObject("http://kelvin-service/kelvin/{value}", Double.class, value);
		return MessageFormat.format("Valor em kelvin é {0} e em fahrenheit é {1}", kelvin, fahrenheit);
	}


}
