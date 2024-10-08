package com.firstspring.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	{
		System.out.println("Global EXCEPTION HANDLER INSTANTIATED");
	}
   
	@ExceptionHandler(value= {IllegalArgumentException.class})
	protected ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException e){
		 String response= e.getMessage();
		 return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {RecordNotFoundException.class})
	protected ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException e){
		 String response= e.getMessage();
		 return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value= {Exception.class})
	protected ResponseEntity<Object> handleException(Exception e){
		 String response= e.getMessage();
		 return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
