package com.example.demo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.configuration.DbSettings;

@RefreshScope
@RestController
@RequestMapping("/hello")
public class HelloRestController {
	
	@Value("${my.greeting: default value}")
	private String greeting;
	
	@Value("${list.values}")
	private List<String> listValues;
	
	@Value("#{${db.connection}}")
	private Map<String, String> dbValues;
	
	@Autowired
	private DbSettings dbSettings;
	
	@GetMapping("/")
	public String display() {
		String display = greeting + listValues + dbValues;
		return display;
	}
	
	@GetMapping("/dbsettings")
	public String dbSettings() {
		return dbSettings.toString();
	}

}
