package com.alvaro.infrastructure.rest.controller;

import com.alvaro.infrastructure.rest.api.OrderApi;
import com.alvaro.infrastructure.rest.api.dto.OrderSearchResultDTO;
import org.springframework.web.bind.annotation.GetMapping;

@CustomRestController
public class OrderController implements OrderApi {

    private OrderApiMapper responseMapper;

    @GetMapping("/health")
    public String getHealth() {
        return "API is working";
    }


    @Override
    public OrderSearchResultDTO getOrders() {
        return null;
    }
}
