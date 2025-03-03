package com.alvaro.domain.ddd.core;

public class DomainError extends RuntimeException {

  public DomainError(final String message) {
    super(message);
  }

  public DomainError(final String message, final Exception cause) {
    super(message, cause);
  }
}