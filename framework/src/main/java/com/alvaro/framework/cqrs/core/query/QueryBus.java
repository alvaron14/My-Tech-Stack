package com.alvaro.framework.cqrs.core.query;

public interface QueryBus {

  <R> R ask(Query<R> query);

}
