package com.alvaro.application.order.query;

import com.alvaro.domain.model.Order;
import com.alvaro.domain.model.OrderRepository;
import com.alvaro.framework.cqrs.core.query.QueryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SearchOrder implements QueryHandler<SearchOrderQuery, Optional<Order>> {

  @Autowired
  private OrderRepository repository;

  @Override
  public Optional<Order> ask(SearchOrderQuery query) {
    return this.repository.find(query.id());
  }
}
