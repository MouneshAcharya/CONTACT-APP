package com.mouneshit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mouneshit.entity.Contact;
import com.mouneshit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactRepository repository;

	@Override
	public List<Contact> getAllContacts() {
		return repository.findAll();
	}

	@Override
	public Contact getContact(int id) {
		Optional<Contact> findById = repository.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public String deleteContact(int id) {
		//making hard delete
		//repository.deleteById(id);
		//making soft delete 
		Optional<Contact> findById = repository.findById(id);
		Contact contact = findById.get();
		contact.setActiveSw("N");
		repository.save(contact);
;		return "SUCCESS";
	}

	@Override
	public String upsert(Contact contact) {
		Contact save = repository.save(contact);
		//if(save.getId() != null) {
			return "SUCCESS";
		//}
		//return "FAILURE";
	}

}
