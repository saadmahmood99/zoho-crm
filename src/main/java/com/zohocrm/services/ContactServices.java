package com.zohocrm.services;

import java.util.List;

import com.zohocrm.entities.Contact;


public interface ContactServices {
	
	public void saveContact(Contact contact);
	
	public List<Contact> findAllContacts();
	
	public Contact getContact(long id);

	

}
