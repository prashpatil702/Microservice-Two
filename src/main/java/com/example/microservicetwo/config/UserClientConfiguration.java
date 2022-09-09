package com.example.microservicetwo.config;

import org.springframework.context.annotation.Bean;

import com.example.microservicetwo.exception.CustomErrorDecoder;

import feign.RequestInterceptor;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.ErrorDecoder;
//@Configuraion if used over here then it will become global and it will be used by every feign client
public class UserClientConfiguration {
	
	//Each request will contain below headers in request
	@Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json");
            requestTemplate.header("Content-Type", "application/json");
            requestTemplate.header("X-Auth-Code", "920d4d0b85443d98d86cb3c8c81d9eed");
        };
    }
	
	//all the requests will contain the basic authentication header.
	@Bean
	public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
	    return new BasicAuthRequestInterceptor("username", "password");
	}
	
	
	@Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }
}
