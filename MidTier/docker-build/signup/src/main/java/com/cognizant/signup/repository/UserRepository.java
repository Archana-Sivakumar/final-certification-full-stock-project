package com.cognizant.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.signup.model.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
	Users findByUserName(String name);
	
	Users findByEmail(String email);
}
