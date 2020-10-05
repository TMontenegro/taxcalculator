package com.montenegro.taxcalculator.exceptions;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity constraintViolationExceptionHandler(ConstraintViolationException constraintViolationException) {
		Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
		String errorMessage = "";
		if (!violations.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			violations.forEach(violation -> builder.append(" " + violation.getMessage()));
			errorMessage = builder.toString();
		} else {
			errorMessage = "ConstraintViolationException occured.";
		}
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}

}