package com.zohocrm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contact;
import com.zohocrm.entities.Lead1;
import com.zohocrm.services.ContactServices;
import com.zohocrm.services.Lead1ServiceImpl;

@Controller
public class LeadController {
	
	
	@Autowired
	private Lead1ServiceImpl lead1Service;
	
	
	@Autowired
	private ContactServices contactService;
	
	
	
	@RequestMapping("/view")
	public String viewCreateLeadPage() {
		return"create_lead";
		
	}
		@RequestMapping("/saveLead")
		public String saveOneLead(@ModelAttribute("lead")Lead1 lead,ModelMap model) {
		lead1Service.saveLead(lead);
		model.addAttribute("lead", lead);
		return"lead_info";
	}
		
		@RequestMapping("/listallleads")
		public String listAllLeads(ModelMap model) {
			List<Lead1> leads = lead1Service.findAllLeads();
			model.addAttribute("leads", leads);
			return "lead_result";
			
		}
		@RequestMapping("/getLeadById")
		public String getLeadById(@RequestParam("id") long id, ModelMap model) {
			Lead1 lead=lead1Service.getLead(id);
			model.addAttribute("lead", lead);
			return "lead_info";
			
		}
		
		@RequestMapping("/convertLead")
		public String convertLead(@RequestParam("id") long id, ModelMap model) {
			Lead1 lead = lead1Service.getLead(id);
			
			Contact contact = new Contact();
			contact.setFirstName(lead.getFirstName());
			contact.setLastName(lead.getLastName());
			contact.setEmail(lead.getEmail());
			contact.setLeadSource(lead.getLeadSource());
			contact.setMobile(lead.getMobile());
			contactService.saveContact(contact);
			
			lead1Service.deleteLead(id);
			
			List<Contact> contacts = contactService.findAllContacts();
			model.addAttribute("contacts", contacts);
			
			return "contact_result";
			
		}
		
}
