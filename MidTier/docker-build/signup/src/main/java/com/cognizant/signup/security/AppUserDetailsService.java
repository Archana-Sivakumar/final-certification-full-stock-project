package com.cognizant.signup.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cognizant.signup.SignupApplication;
import com.cognizant.signup.model.Users;
import com.cognizant.signup.repository.UserRepository;


@Service
public class AppUserDetailsService implements UserDetailsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SignupApplication.class);
	
	@Autowired
	private UserRepository userRepository;
	
	public AppUserDetailsService(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOGGER.info("Start");
		Users user = userRepository.findByUserName(username);
		
		UserDetails appUser = null;
		
		if(user==null) {
			
			throw new UsernameNotFoundException("User Not Found");
			
		} else {
			
			appUser = new AppUser(user);
		
		}
		LOGGER.info("End");
		return appUser;
	}
	

}
