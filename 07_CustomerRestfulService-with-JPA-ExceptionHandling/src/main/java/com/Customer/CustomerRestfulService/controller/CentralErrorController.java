package com.Customer.CustomerRestfulService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Customer.CustomerRestfulService.Exceptions.CustomerNotFoundException;

@ControllerAdvice
public class CentralErrorController {

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> customerNotFound(CustomerNotFoundException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
