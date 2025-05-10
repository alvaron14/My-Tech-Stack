package com.alvaro.framework.cqrs.core.query;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;

@RequiredArgsConstructor
public class QueryProvider<H extends QueryHandler<?, ?>> {

  private final ApplicationContext applicationContext;

  private final Class<H> queryHandler;

  public H get() {
    return applicationContext.getBean(queryHandler);
  }
}