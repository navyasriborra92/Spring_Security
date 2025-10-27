package com.flm.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flm.dao.PersonRepo;
import com.flm.model.Person;

@Service
public class SecurityUserDetails implements UserDetailsService{

	private final PersonRepo personRepo;
	
	public SecurityUserDetails(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Person person = personRepo.findByUsername(username);
		UserDetails userDetails = User.builder()
				.username(person.getUsername()).password(person.getPassword()).build();
		return userDetails;
	}

}
