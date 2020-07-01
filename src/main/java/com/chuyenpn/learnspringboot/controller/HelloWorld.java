package com.chuyenpn.learnspringboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.learnspringboot.dto.User;
import com.chuyenpn.learnspringboot.exceptions.ErrorResponse;
import com.chuyenpn.learnspringboot.exceptions.PasswordValidateException;
import com.chuyenpn.learnspringboot.exceptions.ValidateException;

@RestController
public class HelloWorld {

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping("/hello/{id}")
	public String helloPathVariable(@PathVariable(value="id") String id) {
		return String.format("Hello World, your id is %s", id);
	}
	
	@RequestMapping("/get-user")
	public User getUser() {
		return new User("Nguyen Van A", "ant", "12345678");
	}
	
	@PostMapping("/post-user")
	public String postUser(@Valid @RequestBody User user) {
		return user.toString();
	}
	
	@PostMapping("/post-user2")
	public String postUser2(@RequestBody User user) throws PasswordValidateException {
		if (user.getPassWord().length() < 8) {
			throw new PasswordValidateException("password must be at least 8 characters");
		}
		return user.toString();
	}
	
	@PostMapping("/post-user3")
	public String postUser3(@RequestBody User user) throws ValidateException {
		if (user.getUserName().length() < 6) {
			throw new ValidateException("username must be at least 6 characters");
		}
		return user.toString();
	}
	
	@ExceptionHandler(PasswordValidateException.class)
	public ResponseEntity<ErrorResponse> handleException(PasswordValidateException ex) {
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Validation errors", details);
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
}
