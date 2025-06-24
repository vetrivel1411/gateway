package com.example.Gateway.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GatewayController {

    private final RestTemplate restTemplate;

    public GatewayController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping("/gateway")
    public String getGatewayResponse() {
        return "Welcome to Gateway.." ;
    }

    @GetMapping("/gateway/IAM")
    public String getIAMResponse() {
        return restTemplate.getForObject("http://192.168.30.67:30002/IAM", String.class);
    }

    @GetMapping("/gateway/rendering")
    public String getRenderingResponse() {
        return restTemplate.getForObject("http://192.168.30.67:30003/rendering", String.class);
    }
}
