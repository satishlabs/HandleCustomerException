package com.satishlabs.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyRestEntityExceptionHandler extends ResponseEntityExceptionHandler{
	/*
	@ExceptionHandler({CustomerIdNotFoundException.class})
	public void handleCidNotFound(HttpServletResponse response) throws IOException {
		response.sendError(54321);
	}
	
	@ExceptionHandler({InvalidPhoneNumberException.class})
	public void handlePhoneNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	
	@ExceptionHandler({CityNotFoundException.class})
	public void handleCityNotFound(HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}
	*/
	
	
	//@ExceptionHandler({CustomerIdNotFoundException.class,InvalidPhoneNumberException.class,CityNotFoundException.class})
	@ExceptionHandler({CustomerIdNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleCidNotFound(){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setTimeDateTime(LocalDateTime.now());
		errorMessage.setError("Customer Id is not available...");
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({InvalidPhoneNumberException.class})
	public ResponseEntity<ErrorMessage> handlePhoneNotFound(RuntimeException ex,WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setTimeDateTime(LocalDateTime.now());
		errorMessage.setError("This phone number is not available...");
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler({CityNotFoundException.class})
	public ResponseEntity<ErrorMessage> handleCityNotFound(RuntimeException ex,WebRequest request){
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setTimeDateTime(LocalDateTime.now());
		errorMessage.setError("This City not found in DB...");
		errorMessage.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.NOT_FOUND);
	}
}
