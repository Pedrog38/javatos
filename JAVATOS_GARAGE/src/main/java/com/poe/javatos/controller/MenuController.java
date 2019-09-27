package com.poe.javatos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/Menu")
public class MenuController {
	
	@GetMapping(value ="A")
	public String afficherMenuAdmin (ModelMap model) 
	{
		
		return "menuA";
	}
	
	@GetMapping(value ="C")
	public String afficherMenuCommercial (ModelMap model) 
	{
		
		return "menuC";
	}
	
	@GetMapping(value ="M")
	public String afficherMenuMagasinier (ModelMap model) 
	{
		
		return "menuM";
	}

}
