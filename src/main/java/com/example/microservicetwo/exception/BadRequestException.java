package com.example.microservicetwo.exception;

public class BadRequestException extends Exception {

	String message;

	BadRequestException(String str) {
		message = str;
	}

	public String toString() {
		return ("Custom Exception Occurred : " + message);
	}
}
