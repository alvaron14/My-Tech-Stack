package com.alvaro.framework.cqrs.core.query;

import com.alvaro.framework.cqrs.core.ProviderLocator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Spring backed Query Bus.
 */
@Component
@RequiredArgsConstructor
public class SpringQueryBus implements QueryBus {

  private final ProviderLocator providerLocator;

  @Override
  @SuppressWarnings("unchecked")
  public <R> R ask(Query<R> query) {
    QueryHandler<Query<R>, R> commandHandler = providerLocator.getQueryHandler(query.getClass());
    return commandHandler.ask(query);
  }
}