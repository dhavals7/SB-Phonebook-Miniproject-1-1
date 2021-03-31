package com.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.entity.Contact;
import com.ashokit.service.ContactService;

@Controller
public class ContactOperationsController {

	private ContactService service;

	public ContactOperationsController(ContactService service) {
		super();
		this.service = service;
	}

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {

		Contact contactObject = service.getContactById(contactId);
		model.addAttribute("contact", contactObject);

		return "contact";
	}

	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId, Model model) {

		boolean isDeleted = service.deleteContactById(contactId);
		
		if(isDeleted) {
		
		model.addAttribute("succcessmessage","Contact deleted successfully");
		}else {
		model.addAttribute("failmessage", "Failed to delete the contact");
		}

		return "redirect:view-contacts";
	}

}
