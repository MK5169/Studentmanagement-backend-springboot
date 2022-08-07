package com.tritern.studentmakers.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tritern.studentmakers.entity.SignIn;

public interface SignInRepository extends CrudRepository<SignIn, Long> {
	@Query("FROM SignIn WHERE email = ?1")
	SignIn findByemail(String email);

}
