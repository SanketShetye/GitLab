package com.example.exception;

public class InvalidInputException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidInputException(String errorMessage, Throwable e) {
        super(errorMessage,e);
    }
}
