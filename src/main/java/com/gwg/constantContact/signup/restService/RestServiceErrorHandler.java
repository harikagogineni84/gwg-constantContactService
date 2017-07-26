package com.gwg.constantContact.signup.restService;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestServiceErrorHandler {

	ObjectMapper objectMapper = new ObjectMapper();
	
	public RestServiceError processException(Exception exception) {
		
		RestServiceError error = retrieveMasheryException(exception);
		error.setErrorText("System Error Occurred.");
		
		if(error.getMasheryMessage().contains(""+ HttpStatus.NOT_FOUND.value())) {
			error.setErrorText("An account with the requested Parameters could not be found.");
		}
		
		if(error.getMasheryMessage().contains(""+ HttpStatus.FORBIDDEN.value())) {
			error.setErrorText("Permission denied. Sufficient access is required to access this constant contact account.");
		}
		
		if(error.getMasheryMessage().contains(""+ HttpStatus.SERVICE_UNAVAILABLE.value())) {
			error.setErrorText("The bulk contact push is temporarily unavailable.");
		}
		
		if(error.getMasheryMessage().contains(""+ HttpStatus.GATEWAY_TIMEOUT.value())) {
			error.setErrorText("The connection to this service has timed out.");
		}

		if(error.getMasheryMessage().contains(""+ HttpStatus.INTERNAL_SERVER_ERROR.value())) {
			error.setErrorText("System Error Occurred.");
		}
		
		return error;
	}

	private RestServiceError retrieveMasheryException(Exception exception) {
	RestServiceError error = new RestServiceError();
	error.setMasheryMessage(exception.getMessage());
		return error;
	}

	public String convertToJSONResponse(RestServiceError error) {
		String json;
		try {
			json = objectMapper.writeValueAsString(error);
		} catch (Exception e) {
			return "Error: Malformed JSON Error object. Please contact system administrator.";
		}
		return json;
	}

}
