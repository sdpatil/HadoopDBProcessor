package com.spnotes.hadoop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.hadoop.mapreduce.lib.db.DBWritable;

public class ContactWritable implements DBWritable{
	private Contact contact;
	public void write(PreparedStatement statement) throws SQLException {
		System.out.println("Inside ContactWritable.write()");
	}

	public void readFields(ResultSet resultSet) throws SQLException {
		contact = new Contact();
		contact.setContactId(resultSet.getInt("CONTACTID"));
		contact.setfName(resultSet.getString("FNAME"));
		contact.setlName(resultSet.getString("LNAME"));
		contact.setEmail(resultSet.getString("EMAIL"));
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

}
