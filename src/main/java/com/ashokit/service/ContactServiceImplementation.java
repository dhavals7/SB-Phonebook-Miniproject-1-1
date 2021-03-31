package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashokit.entity.Contact;
import com.ashokit.repository.ContactRepository;

//making the object of the ContactServiceImplementation class as Spring Bean with @Service Annotation
@Service
public class ContactServiceImplementation implements ContactService {

	private ContactRepository repository;

//doing constructor-injection of the ContactRepository object.
	public ContactServiceImplementation(ContactRepository repository) {
		this.repository = repository;

	}

	public boolean saveOrUpdateContact(Contact contact) {
		Contact savedObject = repository.save(contact);
		/*
		 * if (savedObject.getContactId() != null) { return true; }else { return false;
		 * }
		 */

		return savedObject.getContactId() != null;
	}

	@Override
	public List<Contact> getAllContacts() {
		/*
		 * List<Contact> findAll=repository.findAll(); return findAll;
		 */
		return repository.findAll();
	}

	@Override
	public boolean deleteContactById(Integer contactId) {

		boolean isDeleted = false;
		try {
			repository.deleteById(contactId);
			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return isDeleted;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = repository.findById(contactId);

		if (findById.isPresent()) {
			Contact contact = findById.get();
			return contact;
		}
		return null;
	}

}
