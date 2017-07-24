package com.gwg.constantContact.signup.restService;

public class RestServiceError {
	
	public String masheryMessageKey;
	public String masheryMessageText;
	public String errorText;
	
	public String getMasheryMessageKey() {
		return masheryMessageKey;
	}
	public void setMasheryMessageKey(String masheryMessageKey) {
		this.masheryMessageKey = masheryMessageKey;
	}
	public String getMasheryMessageText() {
		return masheryMessageText;
	}
	public void setMasheryMessageText(String masheryMessageText) {
		this.masheryMessageText = masheryMessageText;
	}
	public String getErrorText() {
		return errorText;
	}
	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	
}
