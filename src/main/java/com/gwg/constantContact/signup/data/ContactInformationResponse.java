package com.gwg.constantContact.signup.data;

public class ContactInformationResponse {
	private String id;
	private Integer contact_count;
	private String created_date;
	private String modified_date;
	private String name;
	private String status;
	
	public ContactInformationResponse(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getContact_count() {
		return contact_count;
	}
	public void setContact_count(Integer contact_count) {
		this.contact_count = contact_count;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
