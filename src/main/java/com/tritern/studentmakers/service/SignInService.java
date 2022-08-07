package com.tritern.studentmakers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tritern.studentmakers.entity.SignIn;
import com.tritern.studentmakers.passwordsalt.PasswordSalt;
import com.tritern.studentmakers.repository.SignInRepository;

@Service
public class SignInService {
	@Autowired
	SignInRepository repository;
	
	@Autowired
	private PasswordSalt passwordSalt;

	public String getValidation(String emailId, String password) {
		try {
			if (emailId.equals(null) && password.equals(null)) {
				return "values does not exists";
			} else {
				SignIn signin = repository.findByemail(emailId);
				if (signin.getActive().equals("1")) {
					String hashcode = signin.getHashCode();
					String salt = passwordSalt.generateSecurePassword(password, hashcode);
					if (salt.equals(signin.getPassword())) {
						return signin.getRole();
					} else {
						return "invalid user";
					}
				} else
					return "Account not activated";
			}

		} catch (Exception e) {
			throw e;
		}
	}

}
