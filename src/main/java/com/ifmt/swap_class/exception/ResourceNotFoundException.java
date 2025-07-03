package com.ifmt.swap_class.exception;

public class ResourceNotFoundException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String message) {
    super(message);
  }

  public ResourceNotFoundException(String resource, Long id) {
    super(String.format("%s não encontrado com id: %d", resource, id));
  }
}