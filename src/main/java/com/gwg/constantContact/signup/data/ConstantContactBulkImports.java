package com.gwg.constantContact.signup.data;

import java.util.ArrayList;
import java.util.List;


public class ConstantContactBulkImports {
	private List<ContactImportData> import_data;
	private List<String> lists = new ArrayList<String>();
	private List<String> column_names;
	
	public List<ContactImportData> getImport_data() {
		return import_data;
	}
	public void setImport_data(List<ContactImportData> import_data) {
		this.import_data = import_data;
	}
	public List<String> getLists() {
		return lists;
	}
	public void setLists(List<String> lists) {
		this.lists = lists;
	}
	public List<String> getColumn_names() {
		return column_names;
	}
	public void setColumn_names(List<String> column_names) {
		this.column_names = column_names;
	}

}
