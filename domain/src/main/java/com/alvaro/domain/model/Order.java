package com.alvaro.domain.model;

import com.alvaro.domain.ddd.core.AggregateRoot;
import com.alvaro.domain.model.vo.OrderId;


public class Order extends AggregateRoot<OrderId> {

    public Order(final OrderId id) {
        super(id);
    }

}
