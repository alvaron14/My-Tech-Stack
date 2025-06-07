package com.alvaro.framework.ddd.core;

import java.util.Optional;

public interface AggregateRootRepository <A extends AggregateRoot<I>, I extends AggregateRootId<?>> {

  default A get(final I id) {
    return find(id).orElseThrow(() -> new AggregateNotFoundError(id));
  }

  Optional<A> find(I id);

  void save(A aggregateRoot);

}
