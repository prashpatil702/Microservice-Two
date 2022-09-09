package com.example.microservicetwo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.microservicetwo.config.UserClientConfiguration;

@FeignClient(name="microservice-one",url="localhost:8081",configuration = UserClientConfiguration.class)
public interface FeignService {

	@GetMapping("/getMessageFromMS1")
	public String getMessage();
}
