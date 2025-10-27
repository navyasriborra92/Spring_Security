package com.flm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.flm.model.Person;

@Repository
@EnableJpaRepositories
public interface PersonRepo extends JpaRepository<Person, Long>{

	Person findByUsername(String username);

}
