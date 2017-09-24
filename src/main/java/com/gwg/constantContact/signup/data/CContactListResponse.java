package com.gwg.constantContact.signup.data;

import java.util.List;

public class CContactListResponse {
	
    //must have default constructor 
    public CContactListResponse() {
    }
    
	private List<ContactInformationResponse> contactList;

	public List<ContactInformationResponse> getContactList() {
		return contactList;
	}

	public void setContactList(List<ContactInformationResponse> contactList) {
		this.contactList = contactList;
	}
}
