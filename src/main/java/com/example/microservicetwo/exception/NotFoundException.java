package com.example.microservicetwo.exception;

public class NotFoundException extends Exception {

	String message;

	NotFoundException(String str) {
		message = str;
	}

	public String toString() {
		return ("Custom Exception Occurred : " + message);
	}

}
