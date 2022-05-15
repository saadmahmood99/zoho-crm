package com.zohocrm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm.entities.Lead1;
import com.zohocrm.repositories.LeadRepository;

@Service
public class Lead1ServiceImpl implements Lead1Services {

	@Autowired
	private LeadRepository leadRepo;
	
	@Override
	public void saveLead(Lead1 lead) {
		try {
			leadRepo.save(lead);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Lead1> findAllLeads() {
		List<Lead1> leads = leadRepo.findAll();
		return leads;
	}

	public Lead1 getLead(long id) {
		Optional<Lead1> findById = leadRepo.findById(id);
		Lead1 lead =findById.get();
		return lead;
	}

	public void deleteLead(long id) {
		leadRepo.deleteById(id);
	}

	
		
		
	

	
		
	}


