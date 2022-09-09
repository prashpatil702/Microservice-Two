package com.example.microservicetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservicetwo.config.Config;

@RestController
public class MS2Controller {

	@Autowired
	private Config config;
	
	@GetMapping("/endPoint")
	public String getValue()
	{
		return config.getValue();
	}
}
