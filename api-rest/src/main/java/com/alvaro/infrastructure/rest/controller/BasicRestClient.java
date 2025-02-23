package com.alvaro.infrastructure.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;

@CustomRestController
public class BasicRestClient {

    @GetMapping("/health")
    public String getHealth() {
        return "API is working";
    }

}
