package com.alvaro.infrastructure.rest.controller;

import com.alvaro.domain.model.Order;
import com.alvaro.domain.model.vo.OrderId;
import com.alvaro.domain.projection.Pagination;
import com.alvaro.infrastructure.rest.api.OrderApi;
import com.alvaro.infrastructure.rest.api.dto.OrderSearchResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {

    @Autowired
    private OrderApiMapper responseMapper;

    @GetMapping("/health")
    public String getHealth() {
        return "API is working";
    }


    @Override
    public OrderSearchResultDTO getOrders() {
        return this.responseMapper.toResponse(
            List.of(new Order(new OrderId(UUID.randomUUID()))),
            new Pagination(10, 0L));
    }
}
