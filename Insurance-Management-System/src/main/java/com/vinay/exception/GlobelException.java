package com.vinay.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vinay.dto.ResponseModel;

@ControllerAdvice
public class GlobelException {
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseModel> responseNotFountException(ResourceNotFoundException rs){
		
		ResponseModel responseModel = new ResponseModel(rs.getMessage(), false, LocalDateTime.now());
		return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
		
	}

}
