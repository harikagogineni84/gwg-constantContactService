package com.gwg.constantContact.signup.restService;

public class ServiceUnAvailableException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ServiceUnAvailableException(){
		super("service is unavailable");
	}

}
