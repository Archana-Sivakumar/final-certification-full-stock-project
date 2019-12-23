package com.cognizant.signup;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.cognizant.signup.exception.UserAlreadyExistsException;
import com.cognizant.signup.model.Role;
import com.cognizant.signup.model.Users;
import com.cognizant.signup.repository.UserRepository;
import com.cognizant.signup.security.AppUserDetailsService;
import com.cognizant.signup.service.UserService;


@SpringBootTest
class SignupApplicationTests {
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@MockBean
	UserRepository userRepository;
	
	@Autowired
    UserService userService;
	
	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	@Test
	void contextLoads() {
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupApplication.class);

	@Test
	public void testSignup() {

		LOGGER.info("Start");
		

		Users user = createUser();
		Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(user);

		Set<Role> role = new HashSet<Role>();
		role.add(new Role(2, "USER"));
		user.setRoleList(role);

		Mockito.when(userRepository.save(user)).thenReturn(user);
		String roleName = null;
		for (Role role1 : user.getRoleList()) {
			roleName = role1.getRole();
		}
		assertEquals("USER", roleName);
		LOGGER.info("End");
	}

	private Users createUser() {
		Users user = new Users(0, "archana","$2a$10$4vOnxL/GmPDC/A1gGcS7Y.Jy8FITiN0SFP0.g5y1eazIPtwIh6NY6",""
				+ "archusiva281@gmail.com",9965628844L, true, "archana" ,null);
		return user;

	}	

	@Test
	public void UserExistExceptionSignup(){
		
		Users user = createUser();
		Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(null);
		assertDoesNotThrow(() -> userService.userSignUp(user));
	}
	@Test
	public void UserExistSignup(){
		
		Users user = createUser();
		Mockito.when(userRepository.findByUserName(user.getUserName())).thenReturn(user);
		assertThrows(UserAlreadyExistsException.class,() -> userService.userSignUp(user));
	}
}
	
	
	

