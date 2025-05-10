package com.alvaro.application.order.query;

import com.alvaro.domain.model.Order;
import com.alvaro.framework.cqrs.core.query.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SearchOrder implements QueryHandler<SearchOrderQuery, Optional<Order>> {

  @Override
  public Optional<Order> ask(SearchOrderQuery query) {
    return Optional.of(new Order(query.id()));
  }
}
