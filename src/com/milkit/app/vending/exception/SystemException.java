package com.milkit.app.vending.exception;

public class SystemException extends ServiceException {
	
	private static int code = ErrorCode.SystemException;
	
	
	public SystemException(String message) {
		super(code, message);
	}
	
}
