package com.javaexpress.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorAPI> handleException(ResourceNotFoundException ex) {
		ErrorAPI errorAPI = new ErrorAPI();
		errorAPI.setTitle(ex.getMessage());
		errorAPI.setDetails(ex.getMessage());
		errorAPI.setLocalDateTime(LocalDateTime.now());
		errorAPI.setStatus(HttpStatus.BAD_GATEWAY.getReasonPhrase());
		errorAPI.setStatuCode(HttpStatus.BAD_GATEWAY.value());
		return new ResponseEntity<>(errorAPI, HttpStatus.BAD_GATEWAY);
	}

}
