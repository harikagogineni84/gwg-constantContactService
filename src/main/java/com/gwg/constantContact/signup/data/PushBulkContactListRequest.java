package com.gwg.constantContact.signup.data;

public class PushBulkContactListRequest {
	private String accessToken;
	private ImportBulkContact bulkImportContacts;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public ImportBulkContact getBulkImportContacts() {
		return bulkImportContacts;
	}
	public void setBulkImportContacts(ImportBulkContact bulkImportContacts) {
		this.bulkImportContacts = bulkImportContacts;
	}
}
