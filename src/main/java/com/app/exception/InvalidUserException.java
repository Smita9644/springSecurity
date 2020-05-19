package com.app.exception;

/**
 * This is custom exception class at the time of login if user with given email
 * and password is not present then we throw this exception
 */
public class InvalidUserException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidUserException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}