package com.cognizant.signup.service;

public interface ConfirmationService {
	public String setTokenForConfirmation(String userName);
	public void confirmMailAddress(String token);
	
}
