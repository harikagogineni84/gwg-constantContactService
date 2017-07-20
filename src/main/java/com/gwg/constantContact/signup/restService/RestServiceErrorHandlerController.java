package com.gwg.constantContact.signup.restService;

import org.springframework.http.HttpStatus;

public class RestServiceErrorHandlerController {

	public String handleException(Exception exception) {
		HttpStatus status = retrieveException(exception);
		String exceptionMessage = "System Error Occurred.";
		
		if(HttpStatus.NOT_FOUND == status) {
			exceptionMessage = "An account with the requested Parameters could not be found.";
		}
		
		if(HttpStatus.FORBIDDEN == status){
			exceptionMessage = "Permission denied. Sufficient access is required to access this constant contact account.";
		}
		
		if(HttpStatus.SERVICE_UNAVAILABLE == status){
			exceptionMessage = "The bulk contact push is temporarily unavailable.";
		}
		
		if(HttpStatus.GATEWAY_TIMEOUT == status){
			exceptionMessage = "The connection to this service has timed out.";
		}

		if(HttpStatus.INTERNAL_SERVER_ERROR == status){
			exceptionMessage = "System Error Occurred.";
		}
		
		return exceptionMessage;
	}

	private HttpStatus retrieveException(Exception exception) {
		// TODO Auto-generated method stub
		return HttpStatus.OK;
	}

}
