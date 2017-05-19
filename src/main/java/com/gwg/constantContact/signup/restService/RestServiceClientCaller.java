package com.gwg.constantContact.signup.restService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class RestServiceClientCaller {
	private static final Logger logger = LogManager.getLogger(RestServiceClientCaller.class);
	private static String API_TOKEN = ""; 
	private static String ACCESS_TOKEN = "";
	private static String BEARER="Bearer ";
	private static String BASE_URI = "https://api.constantcontact.com/v2";
	
	
	public <T> T post(GenericType<T> responseType,String serviceAddress, String pathParams) throws Exception{
		   T response = null;
		   logger.error("started executing a post service with operation :-"+serviceAddress);
			Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
			WebTarget webTarget = client.target(BASE_URI).path(serviceAddress).queryParam("api_key", API_TOKEN);

			if(!StringUtils.isEmpty(pathParams)){
				webTarget.path(pathParams);
			}
			
			Response ccRestResponse = webTarget.request(MediaType.APPLICATION_JSON).headers(buildHeader()).post(Entity.json(pathParams));
			
			if(null!= ccRestResponse && Status.OK.getStatusCode() ==ccRestResponse.getStatus()){
				response = ccRestResponse.readEntity(responseType);
			}else{
				String error = "Status="+ccRestResponse.getStatus()+" with error="+ccRestResponse.readEntity(String.class);
				throw new Exception(error);
			}
		
		    return response;
	}


	private MultivaluedMap<String, Object> buildHeader() {
		MultivaluedMap<String, Object> header = new MultivaluedHashMap<String, Object>();
		List<Object> headerValue = new ArrayList<>();
		headerValue.add(BEARER+ACCESS_TOKEN);
		header.put("Authorization", headerValue);
		return header;
	}
}
