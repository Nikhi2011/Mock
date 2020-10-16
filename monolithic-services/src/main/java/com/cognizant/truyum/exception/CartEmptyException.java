package com.cognizant.truyum.exception;

@SuppressWarnings("serial")
public class CartEmptyException extends Exception {
	String message;

	public CartEmptyException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
