package com.project.app.exam.dto;

import java.io.Serializable;

public class ErrorDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ErrorDto() {
	}

	public ErrorDto(String message, String exception) {
		this.message = message;
		this.exception = exception;
	}

	private String message;
	
	private String exception;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getException() {
		return exception;
	}
	
	public void setException(String exception) {
		this.exception = exception;
	}

	@Override
	public String toString() {
		return "ErrorDto [message=" + message + ", exception=" + exception + "]";
	}
	
}
