package com.ifmt.swap_class.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Data;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @Data
  public static class ErrorResponse {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private HttpStatus status;

    public ErrorResponse(String message, String details, HttpStatus status) {
      this.timestamp = LocalDateTime.now();
      this.message = message;
      this.details = details;
      this.status = status;
    }
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
    ErrorResponse error = new ErrorResponse("Recurso não encontrado", ex.getMessage(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
    ErrorResponse error = new ErrorResponse("Erro de negócio", ex.getMessage(), HttpStatus.BAD_REQUEST);
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
    ErrorResponse error = new ErrorResponse("Erro interno do servidor", ex.getMessage(),
        HttpStatus.INTERNAL_SERVER_ERROR);
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}