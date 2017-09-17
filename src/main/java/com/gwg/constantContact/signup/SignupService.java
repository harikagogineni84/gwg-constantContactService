package com.gwg.constantContact.signup;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gwg.constantContact.signup.restService.ConstantContactRESTServiceCaller;
import com.gwg.constantContact.signup.restService.RestServiceErrorHandler;


@RestController
public class SignupService {
	private static final Logger logger =  LogManager.getLogger(SignupService.class);
	@Resource private ConstantContactRESTServiceCaller serviceCaller;
	
	
	@RequestMapping(value = "/pushBulkContacts", method=RequestMethod.POST)
	public String pushBulkContacts(@RequestBody String pushBulkContacts) throws Exception{
		logger.info("executed basic signupform1");
		
		return serviceCaller.pushBulkContactsIntoConstantContact(pushBulkContacts);
	}
	
	
	@ExceptionHandler
	public String handleException(Exception exception) throws Exception{
		RestServiceErrorHandler errorHandler = new RestServiceErrorHandler();
		return errorHandler.processException(exception);
	}
}
