package com.app.exception;

/**
 * This is custom exception class used when we can't able to locate the
 * resources with primary key
 */
public class NotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
