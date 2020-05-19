package com.app.exception;

/**
 * This is the custom exception class used when data from request is invalid
 */
public class InvalidDataException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidDataException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
