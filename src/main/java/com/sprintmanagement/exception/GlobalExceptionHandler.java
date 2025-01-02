package com.sprintmanagement.exception;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sprintmanagement.dto.ResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
		return new ResponseEntity<>(new ResponseDto(ex.getMessage(), null), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TeamMemberNotFoundException.class)
	public ResponseEntity<Object> handleTeamMemberNotFound(TeamMemberNotFoundException ex) {
		ResponseDto response = new ResponseDto(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StoryNotFoundException.class)
    public ResponseEntity<ResponseDto> handleStoryNotFoundException(StoryNotFoundException ex) {
        ResponseDto response = new ResponseDto(ex.getMessage(), null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return new ResponseEntity<>(new ResponseDto("An error occurred", null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	

}
