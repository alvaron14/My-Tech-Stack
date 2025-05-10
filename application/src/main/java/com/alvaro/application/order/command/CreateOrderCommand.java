package com.alvaro.application.order.command;

import com.alvaro.domain.model.vo.OrderId;
import com.alvaro.framework.cqrs.core.command.Command;

public record CreateOrderCommand(OrderId id) implements Command {

}