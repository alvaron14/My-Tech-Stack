package com.alvaro.framework.cqrs.core.query;

import com.alvaro.framework.cqrs.core.ProviderLocator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring backed Query Bus.
 */
@Component
@RequiredArgsConstructor
public class SpringQueryBus implements QueryBus {

  @Autowired
  private final ProviderLocator providerLocator;

  @Override
  @SuppressWarnings("unchecked")
  public <R> R ask(Query<R> query) {
    QueryHandler<Query<R>, R> commandHandler = (QueryHandler<Query<R>, R>) providerLocator.getQueryHandler(query.getClass());
    return commandHandler.ask(query);
  }
}