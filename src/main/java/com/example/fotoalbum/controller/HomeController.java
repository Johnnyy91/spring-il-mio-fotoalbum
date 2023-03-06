package com.example.fotoalbum.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
	
	@GetMapping
	public String home() {
		return "redirect:foto";
	}

	@GetMapping("/TLStest")
	public String TLStest(Authentication auth) {
		System.out.println("Login OK -- name = " + auth.getName());
		return "TLStest";
	}

}
