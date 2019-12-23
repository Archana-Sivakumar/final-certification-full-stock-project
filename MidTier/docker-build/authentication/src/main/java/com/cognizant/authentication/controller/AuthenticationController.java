package com.cognizant.authentication.controller;

import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.authentication.AuthenticationApplication;
import com.cognizant.authentication.exception.UserRegistrationException;
import com.cognizant.authentication.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
@RequestMapping("")
public class AuthenticationController {
	
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationApplication.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) throws UserRegistrationException {
		
		LOGGER.info("Start");
		
		Map<String, String> data = new HashMap<>();
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String user = authentication.getName();

		data.put("token", generateJwt(getUser(authHeader)));
		if(userRepository.findByUserName(user).isConfirmStatus()) {
			data.put("role", role);
			data.put("user", user);
			LOGGER.info("End");
			return data;
		} else {
			throw new UserRegistrationException("REJECTED");
		}
		

	}

	private String getUser(String authHeader) {
		
		LOGGER.info("Start");
        
		String header[] = authHeader.split(" ");
		String encodedCredentials = header[1];
		LOGGER.debug(header[1]);

		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		LOGGER.info("End");
		return decodedCredentials.split(":")[0];
	}

	private String generateJwt(String user) {
		
		LOGGER.info("Start");
		
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		builder.setIssuedAt(new Date());

		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();
		LOGGER.info("End");
		
		return token;
	}
}
