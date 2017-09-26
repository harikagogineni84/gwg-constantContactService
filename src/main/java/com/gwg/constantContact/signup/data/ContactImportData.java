package com.gwg.constantContact.signup.data;

import java.util.List;

public class ContactImportData {
	private List<String> email_addresses;
	private String first_name;
	private String last_name;
	private String birthday_month;
	private String birthday_day;
	private String anniversary;
	private String job_title;
	private String company_name;
	private String home_phone;
	private List<ContactAddress> addresses;
	private List<CustomFields> custom_fields;
	
	public List<String> getEmail_addresses() {
		return email_addresses;
	}
	public void setEmail_addresses(List<String> email_addresses) {
		this.email_addresses = email_addresses;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getBirthday_month() {
		return birthday_month;
	}
	public void setBirthday_month(String birthday_month) {
		this.birthday_month = birthday_month;
	}
	public String getBirthday_day() {
		return birthday_day;
	}
	public void setBirthday_day(String birthday_day) {
		this.birthday_day = birthday_day;
	}
	public String getAnniversary() {
		return anniversary;
	}
	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}
	public String getJob_title() {
		return job_title;
	}
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getHome_phone() {
		return home_phone;
	}
	public void setHome_phone(String home_phone) {
		this.home_phone = home_phone;
	}
	public List<ContactAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<ContactAddress> addresses) {
		this.addresses = addresses;
	}
	public List<CustomFields> getCustom_fields() {
		return custom_fields;
	}
	public void setCustom_fields(List<CustomFields> custom_fields) {
		this.custom_fields = custom_fields;
	}

}
