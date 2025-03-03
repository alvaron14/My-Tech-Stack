package com.alvaro.domain.ddd.core;

import lombok.ToString;

@ToString
public abstract class AggregateRoot<I extends AggregateRootId<?>> extends Entity<I> {

  protected AggregateRoot(final I id) {
    super(id);
  }

}