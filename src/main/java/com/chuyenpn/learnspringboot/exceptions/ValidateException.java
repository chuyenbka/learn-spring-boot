package com.chuyenpn.learnspringboot.exceptions;

public class ValidateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ValidateException(String exception) {
        super(exception);
    }
}
