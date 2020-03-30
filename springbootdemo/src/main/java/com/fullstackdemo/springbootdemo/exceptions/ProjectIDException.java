package com.fullstackdemo.springbootdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ProjectIDException extends RuntimeException{
	
	public ProjectIDException(String message) {
		super(message);
	}
}
