package com.milkit.app.vending.exception;


public class InvalidCurrencyException extends ServiceException {
	
	private static final long serialVersionUID = 982309731424817548L;
	
	
	private static int code = ErrorCode.InvalidCurrencyException;
	
	
	public InvalidCurrencyException(String message) {
		super(code, message);
	}

}
