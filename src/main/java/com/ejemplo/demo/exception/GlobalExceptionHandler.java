package com.ejemplo.demo.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ejemplo.demo.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> manejarValidacion(MethodArgumentNotValidException ex){
		Map<String,String> detalles = new HashMap<>();
		
		for(FieldError error : ex.getBindingResult().getFieldErrors()) {
			detalles.put(error.getField(), error.getDefaultMessage());
		}
		
		ErrorResponse body = new ErrorResponse(
				"VALIDATION_ERROR",
				"Uno o mas campos son invalidos",
				Instant.now(),
				detalles);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> manejarGenerica(Exception ex){
		ErrorResponse body = new ErrorResponse(
				"INTERNAL_ERROR",
				"Ocurrio un error interno",
				Instant.now(),
				Map.of()
				);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> manejarReglaDeNegocio(IllegalArgumentException ex){
		ErrorResponse body = new ErrorResponse(
				"BUISNESS_RULE_ERROR",
				ex.getMessage(),
				Instant.now(),
				Map.of()
				);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
		
		
	}

}
