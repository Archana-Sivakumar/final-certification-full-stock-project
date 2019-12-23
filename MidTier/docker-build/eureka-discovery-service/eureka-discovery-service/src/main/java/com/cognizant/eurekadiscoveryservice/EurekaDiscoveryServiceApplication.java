package com.cognizant.eurekadiscoveryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer

public class EurekaDiscoveryServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaDiscoveryServiceApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("START");
		
		SpringApplication.run(EurekaDiscoveryServiceApplication.class, args);
		
		LOGGER.info("END");
	}

}
