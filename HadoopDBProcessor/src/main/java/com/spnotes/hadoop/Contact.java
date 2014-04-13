package com.spnotes.hadoop;

import org.apache.hadoop.io.ObjectWritable;

public class Contact extends ObjectWritable{

	int contactId;
	String fName;
	String lName;
	String email;
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", fName=" + fName
				+ ", lName=" + lName + ", email=" + email + "]";
	}
	
	
}
