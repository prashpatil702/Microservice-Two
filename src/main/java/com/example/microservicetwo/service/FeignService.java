package com.example.microservicetwo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="microservice-one",url="localhost:8081")
public interface FeignService {

		@GetMapping("/endPoint")
		public String getValue();
}
