package com.gwg.constantContact.signup.restService;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties("cc")
public class CCAuthenticationProperties {
	
	private String publicApiKey;
	private String privateApiKey;
	private String accessToken;


	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getPublicApiKey() {
		return publicApiKey;
	}

	public void setPublicApiKey(String publicApiKey) {
		this.publicApiKey = publicApiKey;
	}
	
	public String setPrivateApiKey() {
		return privateApiKey;
	}

	public void setPrivateApiKey(String accessToken) {
		this.privateApiKey = privateApiKey;
	}
}
