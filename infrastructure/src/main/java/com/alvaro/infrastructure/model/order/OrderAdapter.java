package com.alvaro.infrastructure.model.order;

import com.alvaro.domain.model.Order;
import com.alvaro.domain.model.OrderRepository;
import com.alvaro.domain.model.vo.OrderId;
import com.alvaro.infrastructure.model.order.entity.OrderJpaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderAdapter implements OrderRepository {

  @Autowired
  private OrderEntityRepository repository;

  @Autowired
  private OrderMapper mapper;

  @Override
  public Optional<Order> find(OrderId id) {
    return this.repository.findById(id.value())
        .map(this.mapper::toDomain);
  }

  @Override
  public void save(Order aggregateRoot) {
    final var id = aggregateRoot.getId();
    final var entity = this.repository
        .findById(id.value())
        .orElseGet(() -> this.create(id));

    this.mapper.updateEntity(entity, aggregateRoot);

    this.repository.save(entity);
  }

  private OrderJpaEntity create(final OrderId orderId) {
    return new OrderJpaEntity()
        .setId(orderId.value());
  }
}
