package com.cognizant.signup.service;


public interface EmailService {
	
		void send(String from, String to, String title, String body);
	
}
