package com.alvaro.domain.model;

import com.alvaro.domain.model.vo.OrderId;
import com.alvaro.framework.ddd.core.AggregateRoot;

public class Order extends AggregateRoot<OrderId> {

    public Order(final OrderId id) {
        super(id);
    }

}
