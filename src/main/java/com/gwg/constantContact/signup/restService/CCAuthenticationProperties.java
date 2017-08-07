package com.gwg.constantContact.signup.restService;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties("cc")
public class CCAuthenticationProperties {
	
	private String api_token;
	
	public String getApi_token() {
		return public_api_token;
	}

	public void setApi_token(String public_api_token) {
		this.public_api_token = public_api_token;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	private String access_token;

}
