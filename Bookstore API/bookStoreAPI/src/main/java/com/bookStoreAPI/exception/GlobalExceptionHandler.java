package com.bookStoreAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AuthorIdNotFoundExeption.class)
	ResponseEntity AuthorIdNotFound(){
		return new ResponseEntity("AuthorIdNotFound",HttpStatus.NOT_FOUND);		
	}

}
