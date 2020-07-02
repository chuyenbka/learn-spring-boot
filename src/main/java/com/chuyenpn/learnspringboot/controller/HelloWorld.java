package com.chuyenpn.learnspringboot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chuyenpn.learnspringboot.dto.User;
import com.chuyenpn.learnspringboot.exceptions.ErrorResponse;
import com.chuyenpn.learnspringboot.exceptions.PasswordValidateException;
import com.chuyenpn.learnspringboot.exceptions.ValidateException;

@RestController
public class HelloWorld {

	@Autowired
	MessageSource messageSource;

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/hello/{id}")
	public String helloPathVariable(@PathVariable(value = "id") String id) {
		return String.format("Hello World, your id is %s", id);
	}
	
	@RequestMapping("/hello-in-other-language")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public String helloInOtherLanguage(Locale locale) {
		return messageSource.getMessage("hello.message", null, locale);
	}
	
	@RequestMapping("/hello-with-response-header")
	public ResponseEntity<String> helloResponseWithHeaer() {
		HttpHeaders headers = new HttpHeaders();
	    headers.add("X-Hello", "response entity");
	         
	    return new ResponseEntity<>(
	      "Custom header set", headers, HttpStatus.OK);
	}
	
	@GetMapping("/hello-with-response-header-manual")
	void manual(HttpServletResponse response) throws IOException {
	    response.setHeader("Custom-Header", "foo");
	    response.setStatus(200);
	    response.getWriter().println("Hello World!");
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
