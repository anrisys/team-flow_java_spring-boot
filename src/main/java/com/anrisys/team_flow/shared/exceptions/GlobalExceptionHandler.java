package com.anrisys.team_flow.shared.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.anrisys.team_flow.users.exceptions.EmailAlreadyExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	// === COMMON EXCEPTIONS ===
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
				.map(error -> new FieldError(error.getField(), error.getDefaultMessage())).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(ErrorResponse.withFields("VALIDATION_ERROR", "Invalid input data", fieldErrors));
	}
	
	// === AUTH SERVICE ==
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleEmailExists(EmailAlreadyExistsException ex) {
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body(ErrorResponse.fromException(ex));
	}

	// === FALLBACK ==
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorResponse.fromMessage("INTERNAL_SERVER_ERROR", "An error occured"));
	}
}
