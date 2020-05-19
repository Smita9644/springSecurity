package com.app.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class UserAppExceptionHandler {

	/**
	 * This method will handle the Invalid data in request.
	 * 
	 * @param ex
	 * @return error message.
	 */
	@ExceptionHandler(InvalidDataException.class)
	public @ResponseBody ExceptionResponse MyMessage(InvalidDataException ex, final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());
		error.setRequestedURI(request.getRequestURI());
		error.setStatuscode(422);
		error.setResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY);
		return error;
	}

	/**
	 * This method will handle the invalid user in request.
	 * 
	 * @param ex
	 * @return error message.
	 */
	@ExceptionHandler(InvalidUserException.class)
	public @ResponseBody ExceptionResponse MyMessage(InvalidUserException ex, final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());
		error.setRequestedURI(request.getRequestURI());
		error.setStatuscode(401);
		error.setResponseStatus(HttpStatus.UNAUTHORIZED);
		return error;
	}

	/**
	 * This method will handle the Not found exception in request.
	 * 
	 * @param ex
	 * @return error message.
	 */
	@ExceptionHandler(NotFoundException.class)
	public @ResponseBody ExceptionResponse MyMessage(NotFoundException ex, final HttpServletRequest request) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(ex.getMessage());
		error.setRequestedURI(request.getRequestURI());
		error.setStatuscode(404);
		error.setResponseStatus(HttpStatus.NOT_FOUND);
		return error;
	}
}
