package com.flm.service;

import org.springframework.stereotype.Service;

import com.flm.dao.PersonRepo;
import com.flm.model.Person;

@Service
public class PersonServiceImpl implements PersonService{

	private final PersonRepo personRepo;
	public PersonServiceImpl(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	@Override
	public Person savePersonDetails(Person person) {
		// TODO Auto-generated method stub
		Person save = personRepo.save(person);
		return save;
	}

}
