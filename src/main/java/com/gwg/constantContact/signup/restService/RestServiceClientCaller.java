package com.gwg.constantContact.signup.restService;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
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
	@Resource private CCAuthenticationProperties authenticationProperties;
	private static String BEARER="Bearer ";
	private static String BASE_URI = "https://api.constantcontact.com/v2";
	
	
	public <T> T post(GenericType<T> responseType,String serviceAddress, String pathParams, String accessToken) throws Exception{
		   T response = null;
		   logger.info("started executing a post service with operation :-"+serviceAddress);
			Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
			WebTarget webTarget = client.target(BASE_URI).path(serviceAddress).queryParam("api_key", authenticationProperties.getPublicApiKey());

			if(!StringUtils.isEmpty(pathParams)){
				webTarget.path(pathParams);
			}
			
			Response ccRestResponse = webTarget.request(MediaType.APPLICATION_JSON).headers(buildHeader(accessToken)).post(Entity.json(pathParams));
			
			if(null!= ccRestResponse && Status.CREATED.getStatusCode() ==ccRestResponse.getStatus()){
				response = ccRestResponse.readEntity(responseType);
			}else{
				String error = "Status="+ccRestResponse.getStatus()+" with error="+ccRestResponse.readEntity(String.class);
				throw new Exception(error);
			}
		
		    return response;
	}

	public <T> T get(GenericType<T> responseType,String serviceAddress, String accessToken) throws Exception {
		   logger.info("started executing a post service with operation :-"+serviceAddress);
		   T response = null;
		   Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
			WebTarget webTarget = client.target(BASE_URI).path(serviceAddress)
														.queryParam("api_key", authenticationProperties.getPublicApiKey());

			Response ccRestResponse = webTarget.request(MediaType.APPLICATION_JSON).headers(buildHeader(accessToken)).get();
			
			if(null!= ccRestResponse && Status.OK.getStatusCode() ==ccRestResponse.getStatus()){
				response = ccRestResponse.readEntity(responseType);
			}else{
				String error = "Status="+ccRestResponse.getStatus()+" with error="+ccRestResponse.readEntity(String.class);
				throw new Exception(error);
			}
		
		    return response;
	}
	
	
	private MultivaluedMap<String, Object> buildHeader(String accessToken) {
		MultivaluedMap<String, Object> header = new MultivaluedHashMap<String, Object>();
		List<Object> headerValue = new ArrayList<>();
		headerValue.add(BEARER+accessToken);
		header.put("Authorization", headerValue);
		return header;
	}
}
