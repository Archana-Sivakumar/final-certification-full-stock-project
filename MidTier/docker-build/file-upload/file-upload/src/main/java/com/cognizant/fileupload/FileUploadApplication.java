package com.cognizant.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import com.cognizant.fileupload.property.FileStorageProperties;


@SpringBootApplication
@EnableConfigurationProperties({
    FileStorageProperties.class
})
@EnableDiscoveryClient
public class FileUploadApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("START");
		
		SpringApplication.run(FileUploadApplication.class, args);
	
	     LOGGER.info("END");
	}


}