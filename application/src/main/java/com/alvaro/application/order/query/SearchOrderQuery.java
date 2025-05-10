package com.alvaro.application.order.query;

import com.alvaro.domain.model.Order;
import com.alvaro.domain.model.vo.OrderId;
import com.alvaro.framework.cqrs.core.query.Query;

import java.util.Optional;

public record SearchOrderQuery (OrderId id) implements Query<Optional<Order>> {

}
