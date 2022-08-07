package com.tritern.studentmakers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tritern.studentmakers.service.SignInService;

@RestController
@RequestMapping("/studentmakers")
public class SignInController {
	@Autowired
	SignInService service;

	@CrossOrigin
	@GetMapping("/user/{email}/{password}")
	private ResponseEntity<String> getUser(@PathVariable("email") String userName,
			@PathVariable("password") String Password) {
		try {
			String body = service.getValidation(userName, Password);
			return ResponseEntity.status(HttpStatus.OK).body(body);
		} catch (Exception exception) {
			 System.out.println(exception.getStackTrace());
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Something went wrong");
		}
	}

}
