package com.gwg.constantContact.signup.data;

import java.util.List;

public class ImportBulkContact {
	private List<ContactImportData> import_data;
	private List<String> contactNames;
	private List<String> column_names;
	
	public List<String> getColumn_names() { 
		return column_names;
	}
	public void setColumn_names(List<String> column_names) {
		this.column_names = column_names;
	}
	public List<String> getContactNames() {
		return contactNames;
	}
	public void setContactNames(List<String> contactNames) {
		this.contactNames = contactNames;
	}
	public List<ContactImportData> getImport_data() {
		return import_data;
	}
	public void setImport_data(List<ContactImportData> import_data) {
		this.import_data = import_data;
	}

}
