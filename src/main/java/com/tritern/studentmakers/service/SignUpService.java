package com.tritern.studentmakers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tritern.studentmakers.entity.SignUp;
import com.tritern.studentmakers.entity.UserProfile;
import com.tritern.studentmakers.passwordsalt.PasswordSalt;
import com.tritern.studentmakers.repository.SignUpRepository;

@Service
public class SignUpService {
	@Autowired
	private SignUpRepository repository;
	@Autowired
	private PasswordSalt passwordSalt;

	public String saveOrUpdate(SignUp signup) {
		try {
			String salt = passwordSalt.getSalt(30);
			String securePassword = passwordSalt.generateSecurePassword(signup.getPassword(), salt);
			signup.setPassword(securePassword);
			signup.setHashCode(salt);
			if ((repository.findByemailId(signup.getEmail_id()) == null)) {
				signup.setActive(true);
				repository.save(signup);
				return "Registration successfull";
			} else {
				return "Account already registered";
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public UserProfile getUserDetails(String email) {
		try {
			SignUp signup = new SignUp();
			signup = repository.findByemailId(email);
			if (signup != null) {
				UserProfile userProfile = new UserProfile();
				userProfile.setUsername(signup.getName());
				userProfile.setEmail(signup.getEmail_id());
				userProfile.setPhonenumber(signup.getPhone());
				userProfile.setCity(signup.getCity());
				return userProfile;
			} else {
				return null;
			}

		} catch (Exception e) {
			throw e;
		}
	}

	public String updateProfile(UserProfile userProfile) {
		try {
			SignUp signUp = repository.findByemailId(userProfile.getEmail());
			if (signUp != null) {
				signUp.setName(userProfile.getUsername());
				signUp.setEmail_id(userProfile.getEmail());
				signUp.setCity(userProfile.getCity());
				signUp.setPhone(userProfile.getPhonenumber());
				repository.save(signUp);
				return "updated";
			} else {
				return "try again";
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
