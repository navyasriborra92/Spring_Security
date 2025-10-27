package com.flm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flm.model.Person;
import com.flm.service.PersonService;

@RestController
public class SignUpController {

	private final PersonService personService;
	
	public SignUpController(PersonService personService) {
		this.personService= personService;
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/signup")
	public Person signup(@RequestBody Person person) {
		String encodedPassword = passwordEncoder.encode(person.getPassword());
		person.setPassword(encodedPassword);
		Person savePersonDetails = personService.savePersonDetails(person);
		return savePersonDetails;
	}
	
}
