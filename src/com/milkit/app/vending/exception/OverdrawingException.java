package com.milkit.app.vending.exception;

public class OverdrawingException extends ServiceException {
	
	private static int code = ErrorCode.OverdrawingException;
	
	
	public OverdrawingException(String message) {
		super(code, message);
	}
	
}
