package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringGatewayConfig {
	
	@Autowired
	public Node1Config node1Config;
	
	@Autowired
	public Node2Config node2Config;
	
	@Autowired
	public Node3Config node3Config;
	
	@Value("/message/consumer/")
	private String defaultPath;
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
                .route(r -> r.path(defaultPath + node1Config.getRef() + "**")
                        .uri(node1Config.getUri())
                        .id("consumerModule" + node1Config.getRef()))
                
                .route(r -> r.path(defaultPath + node2Config.getRef() + "**")
                        .uri(node2Config.getUri())
                        .id("consumerModule" + node2Config.getRef()))
                
                .route(r -> r.path(defaultPath + node3Config.getRef() + "**")
                        .uri(node3Config.getUri())
                        .id("consumerModule" + node3Config.getRef()))
                
                .build();
	}

}
