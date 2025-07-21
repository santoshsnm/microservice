package com.example.student.exception;

import java.util.Date;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> notFoundException(Exception ex, WebRequest req) {

		ErrorMessage er = new ErrorMessage(500, new Date(), ex.getMessage(), "Interna Server Error");

		return new ResponseEntity<ErrorMessage>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorMessage> notFoundException(NotFoundException ex) {
		ErrorMessage er = new ErrorMessage(400, new Date(), ex.getMessage(), "Path Not Exist");

		return new ResponseEntity<ErrorMessage>(er, HttpStatus.BAD_REQUEST);
	}
}
