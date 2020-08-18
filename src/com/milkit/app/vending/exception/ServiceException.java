package com.milkit.app.vending.exception;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("serial")
public class ServiceException extends Exception {
	private int code = 900;
	
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(int code) {
		this.code = code;
	}
	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(int code, String message) {
    	super(message);
        this.code = code;
    }
    

    public ServiceException(int code, String message, Throwable cause) {
    	super(message, cause);
    	this.code = code;
    }

    public ServiceException(Throwable cause) {
    	super(cause.getMessage(), cause);
    }
    
    public ServiceException(Throwable cause, int code) {
    	super(cause.getMessage(), cause);
		this.code = code;
    }
    
    public void setCode(int code) {
    	this.code = code;
    }

    public int getCode() {
		return this.code;
	}
    
    public String getMessage() {
    	return super.getMessage();
    }
    
	public String getCodeString() {
		return Integer.toString(this.code);
	}
	

	public String getCauseMessage() {
		String retMessage = "[" + this.getCode() + "]";
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		super.printStackTrace(ps);
		
		retMessage += baos.toString().replaceAll("\n", " ");
		
		return retMessage;
	}

}
