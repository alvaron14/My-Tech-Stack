package com.alvaro.framework.ddd.core;

public class AggregateNotFoundError extends DomainError {

  public AggregateNotFoundError(final AggregateRootId<?> id) {
    super("Aggregate root with ID " + id.value() + " of type " + id.getClass().getCanonicalName() + " cannot be found");
  }

}
