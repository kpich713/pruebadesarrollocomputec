package com.edwin.crudspringmongo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.edwin.crudspringmongo.commons.GenericServiceImpl;
import com.edwin.crudspringmongo.dao.api.PersonaRepository;
import com.edwin.crudspringmongo.model.Persona;
import com.edwin.crudspringmongo.service.api.PersonaServiceAPI;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI{
	
	@Autowired
	private PersonaRepository personaRepository; 
	
	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaRepository;
	}

}
