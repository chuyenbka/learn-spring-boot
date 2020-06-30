package com.chuyenpn.learnspringboot.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(ValidateException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(ValidateException ex) {
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse errorDetails = new ErrorResponse("validation errors", details);
        return new ResponseEntity<ErrorResponse>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
