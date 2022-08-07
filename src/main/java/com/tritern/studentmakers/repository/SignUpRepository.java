package com.tritern.studentmakers.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.tritern.studentmakers.entity.SignUp;

public interface SignUpRepository extends CrudRepository<SignUp, Long> {

	@Query("FROM SignUp WHERE email = ?1")
	SignUp findByemailId(String emailId);

}
