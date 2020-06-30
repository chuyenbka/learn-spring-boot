package com.chuyenpn.learnspringboot.exceptions;

public class PasswordValidateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PasswordValidateException(String exception) {
        super(exception);
    }
}
