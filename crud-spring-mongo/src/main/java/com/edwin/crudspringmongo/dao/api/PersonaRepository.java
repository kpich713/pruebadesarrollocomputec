package com.edwin.crudspringmongo.dao.api;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.edwin.crudspringmongo.model.Persona;


public interface PersonaRepository extends MongoRepository<Persona, Long>{

}
