package com.javaexpress.exception;

import jakarta.persistence.EntityNotFoundException;


public class ResourceNotFoundException extends EntityNotFoundException {
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
