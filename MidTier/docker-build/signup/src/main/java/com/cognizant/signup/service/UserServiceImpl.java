package com.cognizant.signup.service;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.cognizant.signup.SignupApplication;
import com.cognizant.signup.exception.UserAlreadyExistsException;
import com.cognizant.signup.model.Role;
import com.cognizant.signup.model.Users;
import com.cognizant.signup.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignupApplication.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Users getUser(String userName) {
		
		return userRepository.findByUserName(userName);
	}

	@Override
	public void userSignUp(Users userDetails) throws UserAlreadyExistsException {
		
		LOGGER.info("Start");

		Users user = userRepository.findByUserName(userDetails.getUserName());

		if (user != null) {
			
			LOGGER.info("End");
			throw new UserAlreadyExistsException();
			
		} else {

			String encodedPassword = encoder.encode(userDetails.getPassword());

			Set<Role> roleList = new HashSet<Role>();
			roleList.add(new Role(2, "USER"));

			userDetails = new Users(0, userDetails.getUserName(),encodedPassword, userDetails.getEmail(), userDetails.getMobileNumber(),userDetails.isConfirmStatus(),userDetails.getPassword(), roleList);

			userRepository.save(userDetails);
			LOGGER.info("End");
		}

	}
	
	
	@Override
	public boolean editProfile(Users user) {
		userRepository.save(user);
		return true;
	}

	@Override
	public boolean updatePassword(Users user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRawPassword(user.getRawPassword());
		userRepository.save(user);
		return true;
	}

	@Override
	public Users getUserByMail(String mail) {
		return userRepository.findByEmail(mail);
	}
	


}
