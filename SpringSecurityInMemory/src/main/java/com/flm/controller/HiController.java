package com.flm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

	@GetMapping("/hi")
	public String getHi() {
		return "hi";
	}

	@GetMapping("/bye")
	public String getBye() {
		return "Bye";
	}	

	@GetMapping("/open")
	public String getOpen() {
		return "Open for all";
	}

	@GetMapping("/noaccess")
	public String getNoAccess() {
		return "Noaccess";
	}
}
