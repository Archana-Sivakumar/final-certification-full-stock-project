package com.cognizant.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cognizant.signup.model.Confirmation;



@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation, Integer> {
	public Confirmation findByToken(String token);
	
	@Query(value="insert into confirmation values(default,:token,:userName);",nativeQuery = true)
	public void saveDetails(@Param("token") String token, @Param("userName") String userName);
	
}
