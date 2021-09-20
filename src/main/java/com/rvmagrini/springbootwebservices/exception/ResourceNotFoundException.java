package com.rvmagrini.springbootwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 9008061682668413076L;

	public ResourceNotFoundException(String message) {
		super(message);
	}

}
