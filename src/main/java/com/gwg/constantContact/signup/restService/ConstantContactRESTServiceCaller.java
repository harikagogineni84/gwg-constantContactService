package com.gwg.constantContact.signup.restService;


import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.core.GenericType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwg.constantContact.signup.ResponseEncrypter;
import com.gwg.constantContact.signup.data.ConstantContactBulkImports;
import com.gwg.constantContact.signup.data.ContactInformationResponse;
import com.gwg.constantContact.signup.data.PushBulkContactListRequest;

import jersey.repackaged.com.google.common.collect.Lists;

@Service
public class ConstantContactRESTServiceCaller {
	private static final Logger logger = LogManager.getLogger(ConstantContactRESTServiceCaller.class);
	@Resource private ObjectMapper mapper;
	@Resource private RestServiceClientCaller restServiceCaller;
	@Resource private CCAuthenticationProperties authenticationProperties;

	
	public String pushBulkContactsIntoConstantContact(String pushBulkContacts) throws Exception{
		String response;
		logger.info("started Executing ConstantContactRESTServiceCaller for signupform:--");
		
		JsonNode pushBulkContactsJsonNode = mapper.readTree(pushBulkContacts);
		
		String accessToken = pushBulkContactsJsonNode.path("accessToken").toString();
		accessToken = accessToken.replaceAll("^\"|\"$", "");
		List<ContactInformationResponse> constantContactListByAccessToken = getContactListCollection(accessToken);
			
		List<String> contactIds = retrieveContactIds(pushBulkContactsJsonNode, constantContactListByAccessToken);
		ConstantContactBulkImports bulkContacts = buildPushBulkContactRequest(pushBulkContacts, contactIds);
		String signupInfo = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(bulkContacts);
		response  = restServiceCaller.post(new GenericType<>(String.class), "activities/addcontacts", signupInfo, accessToken);

//		if(authenticationProperties.getShouldEncryptResponse()){
//			response = ResponseEncrypter.encrypt(response, authenticationProperties.getPrivateApiKey());
//		}
			return response;
	}
	
	private String getNestedValueFromJSONString(JsonNode pushBulkContactsJsonNode, String propertyName) throws JsonProcessingException, IOException{
		return pushBulkContactsJsonNode.at(propertyName).toString();
	}
	

	private ConstantContactBulkImports buildPushBulkContactRequest(String pushBulkContacts, List<String> contactIds) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		PushBulkContactListRequest import_data = mapper.readValue(pushBulkContacts, new TypeReference<PushBulkContactListRequest>() {});
		ConstantContactBulkImports request= new ConstantContactBulkImports();
		request.setImport_data(import_data.getBulkImportContacts().getImport_data());
		request.setColumn_names(import_data.getBulkImportContacts().getColumn_names());
		request.setLists(contactIds);
		return request;
	}
	
	private List<String> retrieveContactIds(JsonNode pushBulkContactsJsonNode, List<ContactInformationResponse> constantContactListByAccessToken) throws JsonParseException, JsonMappingException, JsonProcessingException, IOException {
		List<String> contactNames = new ObjectMapper().readValue(getNestedValueFromJSONString(pushBulkContactsJsonNode, "/bulkImportContacts/contactNames"), new TypeReference<List<String>>() {});
		List<String> lists =  Lists.newArrayList();
		
		if(!CollectionUtils.isEmpty(constantContactListByAccessToken)){
			for (ContactInformationResponse contact : constantContactListByAccessToken) {
				if(contactNames.contains(contact.getName())){
					lists.add(contact.getId());
				}
			}
		}	
		return lists;
	}

	private List<ContactInformationResponse> getContactListCollection(String accessToken) throws Exception{
		logger.info("retrieving contactInformation:-");
		return restServiceCaller.get(new GenericType<List<ContactInformationResponse>>(){}, "lists",accessToken);
	}
	
	
}
