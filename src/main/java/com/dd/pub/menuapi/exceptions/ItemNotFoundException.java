package com.dd.pub.menuapi.exceptions;

public class ItemNotFoundException extends Throwable{

	private static final long serialVersionUID = 8487872017821273347L;

	private String message;
	
	public ItemNotFoundException(){}
	
	public ItemNotFoundException(String message){
		super();
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
		
}