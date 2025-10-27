package com.flm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flm.model.Person;

@RestController
public class LoginController {

	@GetMapping("/login")
	public String login(@RequestBody Person person) {
		return "logged in";
	}
}
