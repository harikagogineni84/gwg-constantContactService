package com.gwg.constantContact.signup.restService;

import org.springframework.http.HttpStatus;

public class RestServiceErrorHandler {

	public RestServiceError processException(Exception exception) {
		
		RestServiceError error = retrieveMasheryException(exception);
		error.setErrorText("System Error Occurred.");
		
		if(error.getMasheryMessageText().contains(""+ HttpStatus.NOT_FOUND.value())) {
			error.setErrorText("An account with the requested Parameters could not be found.");
		}
		
		if(error.getMasheryMessageText().contains(""+ HttpStatus.FORBIDDEN.value())) {
			error.setErrorText("Permission denied. Sufficient access is required to access this constant contact account.");
		}
		
		if(error.getMasheryMessageText().contains(""+ HttpStatus.SERVICE_UNAVAILABLE.value())) {
			error.setErrorText("The bulk contact push is temporarily unavailable.");
		}
		
		if(error.getMasheryMessageText().contains(""+ HttpStatus.GATEWAY_TIMEOUT.value())) {
			error.setErrorText("The connection to this service has timed out.");
		}

		if(error.getMasheryMessageText().contains(""+ HttpStatus.INTERNAL_SERVER_ERROR.value())) {
			error.setErrorText("System Error Occurred.");
		}
		
		return error;
	}

	private RestServiceError retrieveMasheryException(Exception exception) {
	RestServiceError error = new RestServiceError();
	error.setMasheryMessageText(exception.getMessage());
		return error;
	}

}
