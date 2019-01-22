package com.dd.pub.menuapi.bean;

public class ApiError {
	
	private String message;
	private String description;

	public ApiError(String message) {
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}

	public String getDescription() {
		return description;
	}
}