package com.poe.javatos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/MenuController")
public class MenuController {
	
	@GetMapping
	public String afficherMenuAdmin (ModelMap model) 
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		boolean userIsAdmin = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("Admin"));
		
		boolean userIsCom = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("Commercial"));
		
		if(userIsAdmin) 
		{
			return "menuA";
		}
		else if(userIsCom) 
		{
			return "menuC";
		}
		else return "menuM";}
					
		
	}
	
//	@GetMapping(value ="C")
//	public String afficherMenuCommercial (ModelMap model) 
//	{
//		
//		return "menuC";
//	}
//	
//	@GetMapping(value ="M")
//	public String afficherMenuMagasinier (ModelMap model) 
//	{
//		
//		return "menuM";
//	}



