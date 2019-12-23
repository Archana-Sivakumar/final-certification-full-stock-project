package com.cognizant.signup.security;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		LOGGER.info("Start");
//        registry.addMapping("/**").allowedMethods("GET").allowedOrigins("http://localhost:4200");
		registry.addMapping("/**").allowedMethods("*").allowedOrigins("*");
		LOGGER.info("End");
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		System.out.println("*****");
	    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
	    javaMailSender.setHost("smtp.gmail.com");
	    javaMailSender.setPort(587);
	     
	    javaMailSender.setUsername("ctstestmail10@gmail.com");
	    javaMailSender.setPassword("ftwdzvztccnthugz");
	     
	    Properties props = javaMailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return javaMailSender;
	}
}
