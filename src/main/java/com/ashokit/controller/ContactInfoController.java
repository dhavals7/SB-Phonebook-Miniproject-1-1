package com.ashokit.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactInfoController {

	private ContactService service;

	public ContactInfoController(ContactService service) {
		this.service = service;
	}

	@GetMapping("/load-form")
	public String loadForm(Model model) {

		Contact contactobject = new Contact();
//sending data from controller to UI
		model.addAttribute("contact", contactobject);
//returning logical view name
		return "contact";
	}

	@PostMapping("/saveContact")
	public String handleSubmitButton(Contact contact, Model model) {
		// System.out.println(contact);

		boolean isSaved = service.saveOrUpdateContact(contact);

		if (isSaved) {
			model.addAttribute("successmessage", "Contact Saved");

		} else {
			model.addAttribute("failmessage", "Failed to save the contact");

		}

		return "contact";
	}

	@GetMapping("/view-contacts")
	public String handleViewContactsHyperlink(Model model) {

		List<Contact> allContacts = service.getAllContacts();
		model.addAttribute("contacts", allContacts);

		return "contacts-display";

	}

}
