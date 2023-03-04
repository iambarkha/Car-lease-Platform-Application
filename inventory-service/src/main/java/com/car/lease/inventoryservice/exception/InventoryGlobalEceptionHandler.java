package com.car.lease.inventoryservice.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;


@RestControllerAdvice
@Slf4j
public class InventoryGlobalEceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
	 * Default exception handlers
	 * 
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> defaultErrorHandler(Exception e) {
		log.error("Unexpected exception", e);
		return new ResponseEntity<>(new ErrorResponse("An unexpected exception has occurred"), INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,

			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error(ex.getMessage());
		return new ResponseEntity<Object>(new ErrorResponse("Method Argument Not Valid Exception Occured"), status);
	}
	// ---------------------------- Custom Exceptions ----------------------------


		@ExceptionHandler({ InventorySystemException.class })
		public ResponseEntity<ErrorResponse> handleInventorySystemException(InventorySystemException e) {
			log.error(e.getMessage(), e);
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getMessage()), INTERNAL_SERVER_ERROR);
		}

}
