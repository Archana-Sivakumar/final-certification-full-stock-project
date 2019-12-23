package com.cognizant.fileupload.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.cognizant.fileupload.FileUploadApplication;



@Configuration
public class WebConfig implements WebMvcConfigurer {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadApplication.class);
	
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	
    	LOGGER.info("Start");
    	
    	registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
    	
    	LOGGER.info("End");
    }
}
