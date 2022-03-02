package com.atech.exceptionshandler;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.atech.entity.StudentEntityResponse;
import com.atech.entity.StudentNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	ResponseEntity<StudentEntityResponse> handleException(StudentNotFoundException exception){
		
		StudentEntityResponse response = new StudentEntityResponse();
		
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setMessage(exception.getMessage());
		response.setLocalTime(LocalTime.now());
		
		return new ResponseEntity<StudentEntityResponse> (response, HttpStatus.BAD_REQUEST);
	}

}
