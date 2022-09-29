package com.mouneshit.service;

import java.util.List;

import com.mouneshit.entity.Contact;

public interface ContactService {
	
	List<Contact> getAllContacts();
	
	Contact getContact(int id);
	
	String deleteContact(int id);
	
	String upsert(Contact contact);

}
