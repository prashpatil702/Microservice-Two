package com.example.microservicetwo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	
	private static final Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);


	@GetMapping("/sampleApi")
	//@Retry(name = "sampleAPI",fallbackMethod = "hardCodedResponse")
	//@CircuitBreaker(name = "sampleAPI",fallbackMethod = "hardCodedResponse")
	//@RateLimiter(name="default")
	@Bulkhead(name="sample-api")
	public String sampleApi()
	{
		log.info("Before restTemplate");
		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8976",String.class);
		log.info("After restTemplate");
		return response.getBody();
	}
	
	public String hardCodedResponse(Exception e)
	{
		return "HardCoded response";
	}
}
