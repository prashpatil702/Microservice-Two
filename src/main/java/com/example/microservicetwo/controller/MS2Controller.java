package com.example.microservicetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicetwo.config.Config;
import com.example.microservicetwo.service.FeignService;

@RestController
public class MS2Controller {

	@Autowired
	private Config config;
	
	@Autowired
	private FeignService service;
	
	@GetMapping("/endPoint")
	public String getValue()
	{
		return config.getValue();
	}
	
	@GetMapping("/completeMessage")
	public String getMessage()
	{
		String msg1 = service.getValue();
		
		return msg1+" "+"END";
	}
}
