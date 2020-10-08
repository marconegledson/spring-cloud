package com.example.demo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Configuration
@ConfigurationProperties("db")
@Setter @Getter @ToString
public class DbSettings {
	
	private String connection;
	private String host;
	private int port;

}
