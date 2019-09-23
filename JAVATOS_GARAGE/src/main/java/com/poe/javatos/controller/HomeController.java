package com.poe.javatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
	public class HomeController {
	@GetMapping(value="/app/hello")
	public String sayHello(ModelMap model) {
		model.addAttribute("titre", "Site ...");
		model.addAttribute("personne", "CGE ...");
	return "hello";
	}
	
}