package com.app.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * This class is used for custom response message.
 *Lombok provides :
 *           Setters for this ExceptionRespinse class
 *           getters for this ExceptionRespinse class
 */
@Setter
@Getter
public class ExceptionResponse {
	
	private String errorMessage;
	private String requestedURI;
	private HttpStatus responseStatus;
    private int statuscode;
	
    public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

}

