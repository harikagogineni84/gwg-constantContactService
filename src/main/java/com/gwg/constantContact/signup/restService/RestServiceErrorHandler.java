package com.gwg.constantContact.signup.restService;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServiceErrorHandler {

	ObjectMapper objectMapper = new ObjectMapper();
	
	public String processException(Exception exception) throws JsonProcessingException, IOException {
		
		String errorMessage = "System Error Occurred.";
	
		int indexOf = exception.getMessage().lastIndexOf(":");
		String masheryErrorMessage = exception.getMessage().substring(indexOf+1).replace("\"", "").replaceAll("}]", "");
		if(null != errorMessage){
			errorMessage = masheryErrorMessage;
		}
		return errorMessage;
	}
}
