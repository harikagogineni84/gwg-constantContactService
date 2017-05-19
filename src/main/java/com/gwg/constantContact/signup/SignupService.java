package com.gwg.constantContact.signup;

import javax.annotation.Resource;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gwg.constantContact.signup.restService.ConstantContactRESTServiceCaller;


@RestController
public class SignupService {
	private static final Logger logger =  LogManager.getLogger(SignupService.class);
	@Resource private ConstantContactRESTServiceCaller serviceCaller;
	
	
	@RequestMapping(value = "/pushBulkContacts", method=RequestMethod.GET)
	public String pushBulkContacts() throws Exception{
		logger.info("executed basic signupform");

		String signupInfo = buildMockBulkContacts();
		
		return serviceCaller.pushBulkContactsIntoConstantContact(signupInfo );
	}


	private String buildMockBulkContacts() {
		
		String mockSignupformData = 
				"{\"import_data\": [{\"email_addresses\": [\"user1@example.com\"],\"first_name\": \"John\",\"last_name\": \"Smith\",\"birthday_month\":\"1\",\"birthday_day\":\"25\","+
			    "\"anniversary\":\"03/12/2005\",\"job_title\": \"\",\"company_name\": \"My Company\",\"home_phone\": \"5555551212\",\"addresses\": [{\"line1\": \"123 Partridge Lane\","+
			    "\"line2\": \"Apt. 3\",\"city\": \"Anytown\",\"address_type\": \"PERSONAL\",\"state_code\": \"NH\",\"country_code\": \"US\",\"postal_code\": \"02145\"}]"+
			    "}],\"lists\": [\"4\"],\"column_names\": [\"EMAIL\",\"FIRST NAME\",\"LAST NAME\",\"ADDRESS LINE 1\",\"ADDRESS LINE 2\",\"CITY\",\"STATE\","+
			    "\"COUNTRY\",\"Zip/Postal Code\",\"JOB TITLE\",\"COMPANY NAME\",\"HOME PHONE\",\"Custom Field 6\",\"Custom Field 12\"]}";
		
		return mockSignupformData;
		
	}
}
