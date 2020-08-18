package com.milkit.app.vending.exception;

public class InvalidProductException extends ServiceException {
	
	private static int code = ErrorCode.InvalidProductException;
	
	
	public InvalidProductException(String message) {
		super(code, message);
	}
}
