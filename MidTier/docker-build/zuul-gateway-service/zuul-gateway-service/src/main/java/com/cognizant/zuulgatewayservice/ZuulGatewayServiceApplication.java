package com.cognizant.zuulgatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy 
public class ZuulGatewayServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ZuulGatewayServiceApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("START");
		
		SpringApplication.run(ZuulGatewayServiceApplication.class, args);
		
		LOGGER.info("END");
		
	}
	

}
