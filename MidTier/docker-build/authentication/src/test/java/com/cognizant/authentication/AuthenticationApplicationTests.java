package com.cognizant.authentication;


import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.cognizant.authentication.model.Users;
import com.cognizant.authentication.repository.UserRepository;
import com.cognizant.authentication.security.AppUserDetailsService;


@SpringBootTest
class AuthenticationApplicationTests {
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@MockBean
	UserRepository repository;

	@Autowired
	PasswordEncoder bCryptPasswordEncoder;

	@Test
	void contextLoads() {
	}
		

	@Test
	public void testLoadByUserNameNotFoundException() throws UsernameNotFoundException {
		
		Mockito.when(repository.findByUserName("abc")).thenReturn(null);
        assertThrows(UsernameNotFoundException.class,()->appUserDetailsService.loadUserByUsername("abc"));
	
	}
	
	public  Users createUser() {
		Users user = new Users(0, "archana","$2a$10$4vOnxL/GmPDC/A1gGcS7Y.Jy8FITiN0SFP0.g5y1eazIPtwIh6NY6",""
				+ "archusiva281@gmail.com",9965628844L, false, "archana" ,null);
		return user;

	}
}
