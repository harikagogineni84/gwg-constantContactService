package com.gwg.constantContact.signup.restService;


import javax.annotation.Resource;
import javax.ws.rs.core.GenericType;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ConstantContactRESTServiceCaller {
	private static final Logger logger = LogManager.getLogger(ConstantContactRESTServiceCaller.class);
	@Resource private RestServiceClientCaller restServiceCaller;
	
	public String pushBulkContactsIntoConstantContact(String signupInfo) throws Exception{
		logger.info("started Executing ConstantContactRESTServiceCaller for signupform:--"+signupInfo);
		String response  = restServiceCaller.post(new GenericType<>(String.class), "activities/addcontacts", signupInfo);
		return response;
	}

}
