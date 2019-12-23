package com.cognizant.signup.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.signup.model.Confirmation;
import com.cognizant.signup.model.Users;
import com.cognizant.signup.repository.ConfirmationRepository;
import com.cognizant.signup.repository.UserRepository;


@Service
public class ConfirmationServiceImpl implements ConfirmationService{
	@Autowired
	ConfirmationRepository confirmationRepository;
	@Autowired
	UserRepository userRepository;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@Override
	@Transactional
	public String setTokenForConfirmation(String userName) {
		String token=randomAlphaNumeric();
		Confirmation confirmation = new Confirmation(1, token, userName);
		confirmationRepository.save(confirmation);
		return token;
	}
	
	@Override
	@Transactional
	public void confirmMailAddress(String token) {
		Confirmation userConfirmation=confirmationRepository.findByToken(token);
		if(userConfirmation!=null) {
			confirmationRepository.delete(userConfirmation);
			Users user = userRepository.findByUserName(userConfirmation.getUserName());
			user.setConfirmStatus(true);
			userRepository.save(user);
		}
	}
	
	public static String randomAlphaNumeric() {

		int count = 10;
		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {

			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}
		
		System.out.println(builder.toString());
		return builder.toString();

	}
}
