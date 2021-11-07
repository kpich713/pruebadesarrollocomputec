 package com.edwin.crudspringmongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edwin.crudspringmongo.model.Persona;
import com.edwin.crudspringmongo.service.api.PersonaServiceAPI;

@RestController
@RequestMapping("/persona/api/crud")
@CrossOrigin("*")
public class PersonaController {
	
	@Autowired
	private PersonaServiceAPI personaServiceAPI;

	@GetMapping(value = "/all")
	public List <Persona> getAll(){
		return personaServiceAPI.getAll();
	}
	
	@GetMapping(value = "/find/{id}")
	public Persona find(@PathVariable Long id){
		return personaServiceAPI.get(id);
	}
	
	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id , Model model) {
		if(id != null && id != 0) {
			model.addAttribute("persona", personaServiceAPI.get(id));
		}else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Persona> save(@RequestBody Persona persona) {
		Persona obj = personaServiceAPI.save(persona);		
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete/{id}")
	public ResponseEntity<Persona> delete(@RequestBody Long id) {
		Persona persona = personaServiceAPI.get(id); 
		if (persona != null) {
			personaServiceAPI.delete(id);
		}
		else {
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}
	

}
