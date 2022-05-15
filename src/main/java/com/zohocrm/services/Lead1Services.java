package com.zohocrm.services;

import java.util.List;

import com.zohocrm.entities.Lead1;

public interface Lead1Services {
	
	public void saveLead(Lead1 lead);
	
	public List<Lead1> findAllLeads();
	
	public Lead1 getLead(long id);
	
	public void deleteLead(long id) ;

}
