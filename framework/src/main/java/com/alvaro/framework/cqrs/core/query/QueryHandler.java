package com.alvaro.framework.cqrs.core.query;

public interface QueryHandler<Q extends Query<R>, R> {

  R ask(Q query);

}
