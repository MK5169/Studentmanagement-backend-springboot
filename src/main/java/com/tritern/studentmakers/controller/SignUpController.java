package com.tritern.studentmakers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tritern.studentmakers.entity.SignUp;
import com.tritern.studentmakers.entity.UserProfile;
import com.tritern.studentmakers.service.SignUpService;

@RestController
@RequestMapping("/studentmakers")
public class SignUpController {
	@Autowired
	SignUpService service;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	private ResponseEntity<String> saveUser(@RequestBody SignUp signup) {
		try {
			String body = service.saveOrUpdate(signup);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.OK).build();
		}
	}

	@GetMapping("get/user/profile/{email}")
	private ResponseEntity<UserProfile> getUserProfile(@PathVariable("email") String email) {
		try {
			UserProfile body = service.getUserDetails(email);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception exception) {
			System.out.println(exception.getStackTrace());
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("update/userprofile")
	private ResponseEntity<String> updateUserProfile(@RequestBody UserProfile userProfile) {
		try {
			String body = service.updateProfile(userProfile);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}
}
