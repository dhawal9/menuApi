package com.dd.pub.menuapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dd.pub.menuapi.bean.ApiError;

@ControllerAdvice
public class MenuExceptionHandler {

	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ApiError> itemNotFoundException(ItemNotFoundException ex){
		
		ApiError error = new ApiError(ex.getMessage());
		
		ResponseEntity<ApiError> entity = new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
		
		return entity;
		
	}
	
}
