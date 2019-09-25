package com.poe.javatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.poe.javatos.bean.Devis;
import com.poe.javatos.service.crud.ServiceDevisCrudImpl;

@Controller
public class DevisAValiderController {
	
	// j'ai besoin des services de devis
	
	@Autowired
	private ServiceDevisCrudImpl servicedevis;
	
	@RequestMapping(value="/DevisValidation", method = RequestMethod.GET)
	public String afficherDevis() {			
		return "DevisAvalider";
			
		}
	}
	
	
	

