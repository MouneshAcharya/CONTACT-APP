package com.mouneshit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mouneshit.entity.Contact;
import com.mouneshit.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService service;
	
	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts(){
		List<Contact> allContacts = service.getAllContacts();
		return new ResponseEntity<List<Contact>>(allContacts,HttpStatus.OK);
	}
	
	@GetMapping("/contact/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable Integer id){
		Contact contact = service.getContact(id);
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	
	@PostMapping("/contact")
	public ResponseEntity<String> upsertContact(@RequestBody Contact contact){
		String status = service.upsert(contact);
		return new ResponseEntity<String>(status,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/contact/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable Integer id){
		String deleteContact = service.deleteContact(id);
		return new ResponseEntity<String>(deleteContact,HttpStatus.OK);
	}
 
}
