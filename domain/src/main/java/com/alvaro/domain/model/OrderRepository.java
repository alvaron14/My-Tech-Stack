package com.alvaro.domain.model;

import com.alvaro.domain.model.vo.OrderId;
import com.alvaro.framework.ddd.core.AggregateRootRepository;

public interface OrderRepository extends AggregateRootRepository<Order, OrderId> {
}
