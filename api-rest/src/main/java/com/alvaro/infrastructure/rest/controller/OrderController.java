package com.alvaro.infrastructure.rest.controller;

import com.alvaro.application.order.command.CreateOrderCommand;
import com.alvaro.application.order.query.SearchOrderQuery;
import com.alvaro.domain.model.Order;
import com.alvaro.domain.model.vo.OrderId;
import com.alvaro.domain.projection.Pagination;
import com.alvaro.framework.cqrs.core.command.CommandBus;
import com.alvaro.framework.cqrs.core.query.QueryBus;
import com.alvaro.infrastructure.rest.api.OrderApi;
import com.alvaro.infrastructure.rest.api.dto.OrderSearchResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    private final CommandBus commandBus;

    private final QueryBus queryBus;

    private final OrderApiMapper responseMapper;

    @Override
    public OrderSearchResultDTO getOrders() {
        this.commandBus.execute(new CreateOrderCommand(new OrderId(UUID.randomUUID())));

        var result = this.queryBus.ask(new SearchOrderQuery(new OrderId(UUID.randomUUID())));

        return this.responseMapper.toResponse(
            List.of(new Order(new OrderId(UUID.randomUUID()))),
            new Pagination(10, 0L));
    }
}
