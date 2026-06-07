package com.tron.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tron.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristControllerAdvice 
{
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristException(TouristNotFoundException tnf)
	{
		ErrorDetails error = new ErrorDetails(tnf.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleTouristException(Exception e)
	{
		ErrorDetails error = new ErrorDetails(e.getMessage(), LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
