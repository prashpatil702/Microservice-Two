package com.example.microservicetwo.config;

import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;

public class UserClientConfiguration {

	@Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("X-Auth-Code", "920d4d0b85443d98d86cb3c8c81d9eed");
        };
    }
}
