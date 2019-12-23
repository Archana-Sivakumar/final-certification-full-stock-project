package com.cognizant.signup.service;

import org.springframework.stereotype.Service;
import com.cognizant.signup.exception.UserAlreadyExistsException;
import com.cognizant.signup.model.Users;

@Service
public interface UserService {

public Users getUser(String userName);
	
	public Users getUserByMail(String mail);
	
	public boolean editProfile(Users user);
	
	public boolean updatePassword(Users user);

	public void userSignUp(Users user) throws UserAlreadyExistsException;
}
