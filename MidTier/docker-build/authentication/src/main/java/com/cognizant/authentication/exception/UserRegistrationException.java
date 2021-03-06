package com.cognizant.authentication.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class UserRegistrationException extends Exception {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationException.class);
	String message;

	public UserRegistrationException(String message) {
		LOGGER.info("START");
		this.message = message;
		LOGGER.info("END");
	}

	@Override
	public String getMessage() {
		return message;
	}

}