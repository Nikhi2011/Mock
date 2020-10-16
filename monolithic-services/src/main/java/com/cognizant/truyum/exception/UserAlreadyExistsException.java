package com.cognizant.truyum.exception;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends Exception {
	String message;

	public UserAlreadyExistsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
