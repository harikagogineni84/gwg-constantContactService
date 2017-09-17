package com.gwg.constantContact.signup.data;

public class PushBulkContactListRequest {
	private String import_data;
	private String lists;
	private String column_names;

	public String getImport_data() {
		return import_data;
	}
	public void setImport_data(String import_data) {
		this.import_data = import_data;
	}
	public String getLists() {
		return lists;
	}
	public void setLists(String lists) {
		this.lists = lists;
	}
	public String getColumn_names() {
		return column_names;
	}
	public void setColumn_names(String column_names) {
		this.column_names = column_names;
	}


}
