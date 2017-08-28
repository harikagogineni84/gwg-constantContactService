package com.gwg.constantContact.signup.restService;


import javax.annotation.Resource;
import javax.ws.rs.core.GenericType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwg.constantContact.signup.ResponseEncrypter;

@Service
public class ConstantContactRESTServiceCaller {
	private static final Logger logger = LogManager.getLogger(ConstantContactRESTServiceCaller.class);
	@Resource private ObjectMapper mapper;
	@Resource private RestServiceClientCaller restServiceCaller;
	@Resource private CCAuthenticationProperties authenticationProperties;

	
	public String pushBulkContactsIntoConstantContact(String pushBulkContacts) throws Exception{
		String response;
		
		logger.info("started Executing ConstantContactRESTServiceCaller for signupform:--");
		try {
			JsonNode pushBulkContactsJsonNode = mapper.readTree(pushBulkContacts);
			String signupInfo = pushBulkContactsJsonNode.get("bulkImportContacts").toString();
			String accessToken = pushBulkContactsJsonNode.get("accessToken").asText();

			response  = restServiceCaller.post(new GenericType<>(String.class), "activities/addcontacts", signupInfo, accessToken);
		} catch(Exception exception) {
			RestServiceErrorHandler errorHandler = new RestServiceErrorHandler();
			RestServiceError error = errorHandler.processException(exception);
			response = errorHandler.convertToJSONResponse(error);
		}
		
		if(authenticationProperties.getShouldEncryptResponse()){
			response = ResponseEncrypter.encrypt(response, authenticationProperties.getPrivateApiKey());
		}
			return response;
	}
}
