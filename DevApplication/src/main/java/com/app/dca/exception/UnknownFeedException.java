package com.app.dca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class UnknownFeedException extends Exception {

	String message = null;
	
	public UnknownFeedException() {
		message = "Invalid Feed Id, try again";
	}
	
	

	@Override
	public String toString() {
		return "UnknownFeedException [message=" + message + "]";
	}
	/*@ExceptionHandler
	public ResponseEntity<MyExceptionResponse> invalidFeedId(java.util.NoSuchElementException ex)
	{
		
		
		// design custom exception response 
		
		MyExceptionResponse excResponse = new MyExceptionResponse();
		excResponse.setHttpStatus(HttpStatus.BAD_REQUEST.value());
		excResponse.setExceptionMsg("Invalid Feed Id pls try again");
		
		
		return new ResponseEntity<MyExceptionResponse>(excResponse,HttpStatus.BAD_REQUEST);
		
	}*/
	
}
