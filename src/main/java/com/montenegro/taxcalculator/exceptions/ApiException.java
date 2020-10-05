package com.montenegro.taxcalculator.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ApiException extends ResponseStatusException {

	public ApiException(HttpStatus httpStatus, String message) {
		super(httpStatus, message);
	}

}
