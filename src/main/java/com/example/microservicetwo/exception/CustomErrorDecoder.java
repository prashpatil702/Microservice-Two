package com.example.microservicetwo.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400:
			return new BadRequestException("Bad Request....");
		case 404:
			return new NotFoundException("Not found...");
		default:
			return new Exception("Generic error");
		}
	}

}
